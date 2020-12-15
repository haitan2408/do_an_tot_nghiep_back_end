package com.goruslan.socialgeeking.service;

import com.goruslan.socialgeeking.domain.DataRecommend;

import java.util.List;

public interface DataRecommendService {
    List<DataRecommend> findAll();

    DataRecommend findByEmailAddress(String emailAddress);

    void save(List<DataRecommend> dataRecommend);
}
