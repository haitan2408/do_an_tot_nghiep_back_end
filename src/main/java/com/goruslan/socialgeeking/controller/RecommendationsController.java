package com.goruslan.socialgeeking.controller;

import com.goruslan.socialgeeking.domain.RecommendationRecord;
import com.goruslan.socialgeeking.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RecommendationsController {
    @Autowired
    private RecommendService recommendService;

    @GetMapping("/recommendations/{email}")
    public ResponseEntity<RecommendationRecord[]> recommendations(@PathVariable("email")String email) throws Exception {
           RecommendationRecord[] recommendationRecords = recommendService.recommendations(email);
           if(recommendationRecords == null) {
               return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
           } else {
               return new ResponseEntity<>(recommendationRecords,HttpStatus.OK);
           }

        }
}
