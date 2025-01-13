package com.ai.comics.service;

import com.ai.comics.model.Analytics;
import com.ai.comics.model.AnalyticsResponse;
import java.util.List;

/**
 * Service interface for managing analytics records.
 */
public interface AnalyticsService {

    /**
     * Delete an analytics record by ID.
     *
     * @param analyticsId the ID of the analytics record to delete
     * @throws Exception if an error occurs during deletion
     */
    void deleteAnalyticsById(Integer analyticsId) throws Exception;

    /**
     * Get an analytics record by ID.
     *
     * @param analyticsId the ID of the analytics record to retrieve
     * @return the analytics record
     * @throws Exception if an error occurs during retrieval
     */
    AnalyticsResponse getAnalyticsById(Integer analyticsId) throws Exception;

    /**
     * Update an analytics record by ID.
     *
     * @param analyticsId the ID of the analytics record to update
     * @param analytics the analytics data to update
     * @throws Exception if an error occurs during update
     */
    void updateAnalyticsById(Integer analyticsId, Analytics analytics) throws Exception;

    /**
     * Get all analytics records.
     *
     * @return a list of all analytics records
     * @throws Exception if an error occurs during retrieval
     */
    List<AnalyticsResponse> getAllAnalytics() throws Exception;

    /**
     * Create a new analytics record.
     *
     * @param analytics the analytics data to create
     * @throws Exception if an error occurs during creation
     */
    void createAnalytics(Analytics analytics) throws Exception;
}
