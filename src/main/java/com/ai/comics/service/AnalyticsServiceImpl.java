package com.ai.comics.service;

import com.ai.comics.entity.AnalyticsEntity;
import com.ai.comics.model.Analytics;
import com.ai.comics.model.AnalyticsResponse;
import com.ai.comics.repository.AnalyticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the AnalyticsService interface for managing analytics records.
 */
@Service
public class AnalyticsServiceImpl implements AnalyticsService {

    @Autowired
    private AnalyticsRepository analyticsRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAnalyticsById(Integer analyticsId) throws Exception {
        try {
            analyticsRepository.deleteById(analyticsId);
        } catch (Exception e) {
            // Log the exception
            throw new Exception("Error deleting analytics record", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnalyticsResponse getAnalyticsById(Integer analyticsId) throws Exception {
        try {
            AnalyticsEntity entity = analyticsRepository.findById(analyticsId)
                    .orElseThrow(() -> new Exception("Analytics record not found"));
            return convertEntityToModel(entity);
        } catch (Exception e) {
            // Log the exception
            throw new Exception("Error retrieving analytics record", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateAnalyticsById(Integer analyticsId, Analytics analytics) throws Exception {
        try {
            AnalyticsEntity entity = analyticsRepository.findById(analyticsId)
                    .orElseThrow(() -> new Exception("Analytics record not found"));
            entity.setComicId(analytics.getComicId());
            entity.setViews(analytics.getViews());
            entity.setLikes(analytics.getLikes());
            entity.setShares(analytics.getShares());
            entity.setUpdatedAt(analytics.getUpdatedAt());
            analyticsRepository.save(entity);
        } catch (Exception e) {
            // Log the exception
            throw new Exception("Error updating analytics record", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<AnalyticsResponse> getAllAnalytics() throws Exception {
        try {
            List<AnalyticsEntity> entities = analyticsRepository.findAll();
            return entities.stream().map(this::convertEntityToModel).collect(Collectors.toList());
        } catch (Exception e) {
            // Log the exception
            throw new Exception("Error retrieving all analytics records", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createAnalytics(Analytics analytics) throws Exception {
        try {
            AnalyticsEntity entity = convertModelToEntity(analytics);
            analyticsRepository.save(entity);
        } catch (Exception e) {
            // Log the exception
            throw new Exception("Error creating analytics record", e);
        }
    }

    /**
     * Converts an instance of AnalyticsEntity to AnalyticsResponse.
     *
     * @param entity the AnalyticsEntity instance
     * @return the converted AnalyticsResponse
     */
    private AnalyticsResponse convertEntityToModel(AnalyticsEntity entity) {
        AnalyticsResponse response = new AnalyticsResponse();
        response.setAnalyticsId(entity.getAnalyticsId());
        response.setComicId(entity.getComicId());
        response.setViews(entity.getViews());
        response.setLikes(entity.getLikes());
        response.setShares(entity.getShares());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());
        return response;
    }

    /**
     * Converts an instance of Analytics to AnalyticsEntity.
     *
     * @param analytics the Analytics instance
     * @return the converted AnalyticsEntity
     */
    private AnalyticsEntity convertModelToEntity(Analytics analytics) {
        AnalyticsEntity entity = new AnalyticsEntity();
        entity.setAnalyticsId(analytics.getAnalyticsId());
        entity.setComicId(analytics.getComicId());
        entity.setViews(analytics.getViews());
        entity.setLikes(analytics.getLikes());
        entity.setShares(analytics.getShares());
        entity.setCreatedAt(analytics.getCreatedAt());
        entity.setUpdatedAt(analytics.getUpdatedAt());
        return entity;
    }
}
