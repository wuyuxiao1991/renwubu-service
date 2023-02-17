package com.service;


import com.model.request.PageQueryTrainingDetailsRequest;
import com.persistence.entity.TrainingMissionDetails;
import com.persistence.mapper.TrainingMissionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuyuxiao
 */
@Service
public class TrainingMissionService {
    @Resource
    private TrainingMissionMapper trainingMissionMapper;

    public List<TrainingMissionDetails> pageQuery(PageQueryTrainingDetailsRequest request) {
        return trainingMissionMapper.pageQuery(request.getYear(),request.getProvince(), request.getCity(), request.getDistrict(), request.getIdentity(),
                (request.getPageNumber() - 1) * request.getPageSize(), request.getPageSize());
    }


    public int queryNewsTotalCount(PageQueryTrainingDetailsRequest request) {
        return trainingMissionMapper.queryTotalCount(request.getYear(),request.getProvince(),request.getCity(), request.getDistrict(),request.getIdentity());
    }

}