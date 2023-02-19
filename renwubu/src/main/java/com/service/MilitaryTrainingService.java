package com.service;


import com.model.request.PageQueryTrainingDetailsRequest;
import com.model.request.PageQueryYearlyPlanDetailsRequest;
import com.persistence.entity.TrainingMissionDetails;
import com.persistence.entity.YearlyPlanDetails;
import com.persistence.mapper.TrainingMissionDetailMapper;
import com.persistence.mapper.YearlyPlanDetailsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuyuxiao
 */
@Service
public class MilitaryTrainingService {
    @Resource
    private TrainingMissionDetailMapper trainingMissionMapper;
    @Resource
    private YearlyPlanDetailsMapper yearlyPlanDetailsMapper;

    public List<TrainingMissionDetails> pageQueryTrainingMissionDetails(PageQueryTrainingDetailsRequest request) {
        return trainingMissionMapper.pageQuery(request.getSearchKey(), request.getYear(), request.getProvince(), request.getCity(), request.getDistrict(), request.getIdentity(),
                (request.getPageNumber() - 1) * request.getPageSize(), request.getPageSize());
    }


    public int queryTrainingMissionDetailsTotalCount(PageQueryTrainingDetailsRequest request) {
        return trainingMissionMapper.queryTotalCount(request.getSearchKey(), request.getYear(), request.getProvince(), request.getCity(), request.getDistrict(), request.getIdentity());
    }

    public List<YearlyPlanDetails> pageQueryYearlyPanDetail(PageQueryYearlyPlanDetailsRequest request) {
        return yearlyPlanDetailsMapper.pageQuery(request.getSearchKey(), request.getYear(), request.getMonth(), request.getIdentity(),
                (request.getPageNumber() - 1) * request.getPageSize(), request.getPageSize());
    }


    public int queryYearlyPanDetailTotalCount(PageQueryYearlyPlanDetailsRequest request) {
        return yearlyPlanDetailsMapper.queryTotalCount(request.getSearchKey(), request.getYear(), request.getMonth(), request.getIdentity());
    }

}