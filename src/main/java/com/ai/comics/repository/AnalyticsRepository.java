package com.ai.comics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ai.comics.entity.AnalyticsEntity;

@Repository
public interface AnalyticsRepository extends JpaRepository<AnalyticsEntity, Integer> {
    // Additional query methods can be defined here
}