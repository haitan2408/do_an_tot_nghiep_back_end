package com.goruslan.socialgeeking.service.impl;

import com.goruslan.socialgeeking.controller.PostController;
import com.goruslan.socialgeeking.domain.DataRecommend;
import com.goruslan.socialgeeking.domain.RecommendationRecord;
import com.goruslan.socialgeeking.domain.User;
import com.goruslan.socialgeeking.service.DataRecommendService;
import com.goruslan.socialgeeking.service.RecommendService;
import com.goruslan.socialgeeking.service.UserService;
import org.aspectj.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weka.core.*;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.neighboursearch.LinearNNSearch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@Service
public class RecommendServiceImpl implements RecommendService {
    private static final Logger logger = LoggerFactory.getLogger(RecommendServiceImpl.class);
    @Autowired
    private UserService userService;

    @Autowired
    private DataRecommendService dataRecommendService;

    public RecommendationRecord[] recommendations(DataRecommend dataRecommend) throws Exception {
        String email =dataRecommend.getEmailAddress();
        User user = userService.findByEmail(email);
        if (user == null) {
            return null;
        } else {
            DataSource source = new DataSource("dataset//language.arff");
            Instances dataset = source.getDataSet();
            createNewFileData(dataRecommend);
            source = new DataSource("dataset//" + email + ".arff");
            Instances userRating = source.getDataSet();
            Instance userData = userRating.firstInstance();

            LinearNNSearch kNN = new LinearNNSearch(dataset);
            Instances neighbors = null;
            double[] distances = null;

            try {
                neighbors = kNN.kNearestNeighbours(userData, 5);
                distances = kNN.getDistances();
            } catch (Exception e) {
                logger.error("Neighbors could not be found.");
            }

            double[] similarities = new double[distances.length];
            for (int i = 0; i < distances.length; i++) {
                similarities[i] = 1.0 / distances[i];
            }

            Map<String, List<Integer>> recommendations = new HashMap<>();
            for (int i = 0; i < neighbors.numInstances(); i++) {
                Instance currNeighbor = neighbors.get(i);
                for (int j = 0; j < currNeighbor.numAttributes(); j++) {
                    if (userData.value(j) < 1) {
                        String attrName = userData.attribute(j).name();
                        List<Integer> lst = new ArrayList<Integer>();
                        if (recommendations.containsKey(attrName)) {
                            lst = recommendations.get(attrName);
                        }
                        lst.add((int) currNeighbor.value(j));
                        recommendations.put(attrName, lst);
                    }
                }

            }

            List<RecommendationRecord> finalRanks = new ArrayList<>();
            Iterator<String> it = recommendations.keySet().iterator();
            while (it.hasNext()) {
                String atrName = it.next();
                double totalImpact = 0;
                double weightedSum = 0;
                List<Integer> ranks = recommendations.get(atrName);
                for (int i = 0; i < ranks.size(); i++) {
                    int val = ranks.get(i);
                    totalImpact += similarities[i];
                    weightedSum += similarities[i] * val;
                }
                RecommendationRecord rec = new RecommendationRecord();
                rec.setAttributeName(atrName);
                rec.setScore(weightedSum / totalImpact);

                finalRanks.add(rec);
            }
            Collections.sort(finalRanks);
            return new RecommendationRecord[]{finalRanks.get(0), finalRanks.get(1), finalRanks.get(2)};
        }
    }

    private void createNewFileData(DataRecommend dataRecommend) throws IOException {
        String email =dataRecommend.getEmailAddress();
        File myObj = new File("src\\main\\resources\\dataset\\" + email + ".arff");
        myObj.delete();
        myObj.createNewFile();
        FileUtil.copyFile(new File("src\\main\\resources\\dataset\\user.arff"), myObj);
        BufferedWriter writer = new BufferedWriter(new FileWriter("src\\main\\resources\\dataset\\" + email + ".arff", true));
        writer.newLine();
        writer.write(dataRecommend.toString());
        writer.flush();
        writer.close();
    }

    public void createNewFileDataRecommend() throws IOException {
        File myObj = new File("src\\main\\resources\\dataset\\language.arff");
        myObj.delete();
        myObj.createNewFile();
        FileUtil.copyFile(new File("src\\main\\resources\\dataset\\user.arff"), myObj);
        BufferedWriter writer = new BufferedWriter(new FileWriter("src\\main\\resources\\dataset\\language.arff", true));
        List<DataRecommend> dataRecommends = dataRecommendService.findAll();
        for (DataRecommend dataRecommend : dataRecommends) {
            writer.newLine();
            writer.write(dataRecommend.toString());
        }
        writer.flush();
        writer.close();
    }
}
