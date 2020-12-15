package com.goruslan.socialgeeking.repository;

import com.goruslan.socialgeeking.domain.DataRecommend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRecommendRepository extends JpaRepository<DataRecommend, Long> {

    DataRecommend findByEmailAddress(String email);
}
