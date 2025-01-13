package com.ai.comics.api;

import com.ai.comics.model.Analytics;
import com.ai.comics.model.AnalyticsResponse;
import com.ai.comics.service.AnalyticsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
@Tag(name = "analytics", description = "the analytics API")
public class AnalyticsApiController implements AnalyticsApi {

    private final AnalyticsService analyticsService;

    @Autowired
    public AnalyticsApiController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @Override
    public ResponseEntity<Void> analyticsAnalyticsIdDelete(@Parameter(name = "analyticsId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("analyticsId") Integer analyticsId) throws Exception {
        analyticsService.deleteAnalyticsById(analyticsId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<AnalyticsResponse> analyticsAnalyticsIdGet(@Parameter(name = "analyticsId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("analyticsId") Integer analyticsId) throws Exception {
        AnalyticsResponse analyticsResponse = analyticsService.getAnalyticsById(analyticsId);
        return new ResponseEntity<>(analyticsResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> analyticsAnalyticsIdPut(@Parameter(name = "analyticsId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("analyticsId") Integer analyticsId,
                                                        @Parameter(name = "Analytics", description = "", required = true) @Valid @RequestBody Analytics analytics) throws Exception {
        analyticsService.updateAnalyticsById(analyticsId, analytics);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<AnalyticsResponse>> analyticsGet() throws Exception {
        List<AnalyticsResponse> analyticsList = analyticsService.getAllAnalytics();
        return new ResponseEntity<>(analyticsList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> analyticsPost(@Parameter(name = "Analytics", description = "", required = true) @Valid @RequestBody Analytics analytics) throws Exception {
        analyticsService.createAnalytics(analytics);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}