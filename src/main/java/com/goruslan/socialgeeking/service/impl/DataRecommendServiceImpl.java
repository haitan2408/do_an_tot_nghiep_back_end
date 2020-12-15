package com.goruslan.socialgeeking.service.impl;

import com.goruslan.socialgeeking.domain.DataRecommend;
import com.goruslan.socialgeeking.repository.DataRecommendRepository;
import com.goruslan.socialgeeking.service.DataRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataRecommendServiceImpl implements DataRecommendService {
    @Autowired
    private DataRecommendRepository dataRecommendRepository;

    @Override
    public List<DataRecommend> findAll() {
        return dataRecommendRepository.findAll();
    }

    @Override
    public DataRecommend findByEmailAddress(String emailAddress) {
        return dataRecommendRepository.findByEmailAddress(emailAddress);
    }

    @Override
    public void save(List<DataRecommend> dataRecommend) {
        dataRecommendRepository.saveAll(dataRecommend);
    }
}
