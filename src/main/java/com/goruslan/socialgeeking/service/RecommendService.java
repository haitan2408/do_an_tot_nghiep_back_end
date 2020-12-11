package com.goruslan.socialgeeking.service;

import com.goruslan.socialgeeking.domain.RecommendationRecord;

import java.util.List;

public interface RecommendService {
    RecommendationRecord[] recommendations(String email) throws Exception;
}
