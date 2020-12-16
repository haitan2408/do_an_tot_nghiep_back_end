package com.goruslan.socialgeeking.service;

import com.goruslan.socialgeeking.domain.DataRecommend;
import com.goruslan.socialgeeking.domain.RecommendationRecord;

import java.io.IOException;
import java.util.List;

public interface RecommendService {
    RecommendationRecord[] recommendations(DataRecommend dataRecommend) throws Exception;

    void createNewFileDataRecommend() throws IOException;
}
