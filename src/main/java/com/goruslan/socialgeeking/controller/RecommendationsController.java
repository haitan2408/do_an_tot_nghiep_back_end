package com.goruslan.socialgeeking.controller;

import com.goruslan.socialgeeking.domain.DataRecommend;
import com.goruslan.socialgeeking.domain.RecommendationRecord;
import com.goruslan.socialgeeking.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RecommendationsController {
    @Autowired
    private RecommendService recommendService;

    @PostMapping("/recommendations")
    public ResponseEntity<RecommendationRecord[]> recommendations(@RequestBody DataRecommend dataRecommend) throws Exception {
        recommendService.createNewFileData(dataRecommend);
           RecommendationRecord[] recommendationRecords = recommendService.recommendations(dataRecommend);
           if(recommendationRecords == null) {
               return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
           } else {
               return new ResponseEntity<>(recommendationRecords,HttpStatus.OK);
           }

        }
}
