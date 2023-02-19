package com.service;


import com.model.request.PageQueryMilitaryStrengthGuaranteeRequest;
import com.model.request.PageQueryMilitaryStrengthPlanRequest;
import com.model.request.PageQueryMilitaryStrengthRegistrationRequest;
import com.persistence.entity.MilitaryStrengthGuarantee;
import com.persistence.entity.MilitaryStrengthPlan;
import com.persistence.entity.MilitaryStrengthRegistration;
import com.persistence.mapper.MilitaryStrengthGuaranteeMapper;
import com.persistence.mapper.MilitaryStrengthPlanMapper;
import com.persistence.mapper.MilitaryStrengthRegistrationMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuyuxiao
 */
@Service
public class TroopService {
    @Resource
    private MilitaryStrengthPlanMapper militaryStrengthPlanMapper;

    @Resource
    private MilitaryStrengthGuaranteeMapper militaryStrengthGuranteeMapper;

    @Resource
    private MilitaryStrengthRegistrationMapper militaryStrengthRegistrationMapper;

    public List<MilitaryStrengthPlan> pageQueryPlan(PageQueryMilitaryStrengthPlanRequest request) {
        return militaryStrengthPlanMapper.pageQuery(request.getSearchKey(), request.getPlanName(), request.getIdentity(),
                (request.getPageNumber() - 1) * request.getPageSize(), request.getPageSize());
    }


    public int queryPlanTotalCount(PageQueryMilitaryStrengthPlanRequest request) {
        return militaryStrengthPlanMapper.queryTotalCount(request.getSearchKey(), request.getPlanName(), request.getIdentity());
    }

    public List<MilitaryStrengthRegistration> pageQueryRegistration(PageQueryMilitaryStrengthRegistrationRequest request) {
        return militaryStrengthRegistrationMapper.pageQuery(request.getSearchKey(), request.getRequiredBy(), request.getTaskType(), request.getConcreteTask(),
                request.getIdentity(), (request.getPageNumber() - 1) * request.getPageSize(), request.getPageSize());
    }


    public int queryRegistrationTotalCount(PageQueryMilitaryStrengthRegistrationRequest request) {
        return militaryStrengthRegistrationMapper.queryTotalCount(request.getSearchKey(), request.getRequiredBy(), request.getTaskType(), request.getConcreteTask(),
                request.getIdentity());
    }

    public List<MilitaryStrengthGuarantee> pageQueryGuarantee(PageQueryMilitaryStrengthGuaranteeRequest request) {
        return militaryStrengthGuranteeMapper.pageQuery(request.getSearchKey(), request.getRegistrationTask(),
                request.getIdentity(), (request.getPageNumber() - 1) * request.getPageSize(), request.getPageSize());
    }


    public int queryGuaranteeTotalCount(PageQueryMilitaryStrengthGuaranteeRequest request) {
        return militaryStrengthGuranteeMapper.queryTotalCount(request.getSearchKey(), request.getRegistrationTask(),
                request.getIdentity());
    }

}