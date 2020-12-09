package com.goruslan.socialgeeking.controller;

import com.goruslan.socialgeeking.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecommendationsController {
    @Autowired
    private RecommendService recommenderService;

    @GetMapping("/recommendations")
    public ResponseEntity<Void> recommendations() throws Exception {
        try{
            recommenderService.recommendations();
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
