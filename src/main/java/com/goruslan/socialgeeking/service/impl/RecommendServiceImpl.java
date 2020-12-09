package com.goruslan.socialgeeking.service.impl;
import com.goruslan.socialgeeking.domain.RecommendationRecord;
import com.goruslan.socialgeeking.service.RecommendService;
import org.springframework.stereotype.Service;
import weka.core.*;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.neighboursearch.LinearNNSearch;

import java.util.*;

@Service
public class RecommendServiceImpl implements RecommendService {
    public void recommendations() throws Exception {
        DataSource source = new DataSource("dataset//language.arff");
        Instances dataset = source.getDataSet();

        source = new DataSource("dataset//user.arff");
        Instances userRating = source.getDataSet();
        Instance userData = userRating.firstInstance();

        LinearNNSearch kNN = new LinearNNSearch(dataset);
        Instances neighbors = null;
        double[] distances = null;

        try {
            neighbors = kNN.kNearestNeighbours(userData, 5);
            distances = kNN.getDistances();
        } catch (Exception e) {
            System.out.println("Neighbors could not be found.");
            return;
        }

        double[] similarities = new double[distances.length];
        for (int i = 0; i < distances.length; i++) {
            similarities[i] = 1.0 / distances[i];
        }

//        Enumeration nInstances = neighbors.enumerateInstances();

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
                weightedSum += (double) similarities[i] * val;
            }
            RecommendationRecord rec = new RecommendationRecord();
            rec.setAttributeName(atrName);
            rec.setScore(weightedSum / totalImpact);

            finalRanks.add(rec);
        }
        Collections.sort(finalRanks);

        // print top 3 recommendations
        System.out.println(finalRanks.get(0));
        System.out.println(finalRanks.get(1));
        System.out.println(finalRanks.get(2));
    }
}
