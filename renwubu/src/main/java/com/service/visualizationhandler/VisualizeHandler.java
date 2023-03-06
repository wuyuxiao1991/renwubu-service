package com.service.visualizationhandler;

import com.model.dto.StatisticsDto;

import java.util.List;

/**
 * @author wuyuxiao
 */
public interface VisualizeHandler {
    Boolean isSupport(String type);

    public List<StatisticsDto> calculate(String type, String identity) throws Exception;
}
