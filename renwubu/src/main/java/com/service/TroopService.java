package com.service;


import com.model.request.*;
import com.persistence.entity.MilitaryStrengthGuarantee;
import com.persistence.entity.MilitaryStrengthPlan;
import com.persistence.entity.MilitaryStrengthRegistration;
import com.persistence.mapper.MilitaryStrengthGuaranteeMapper;
import com.persistence.mapper.MilitaryStrengthPlanMapper;
import com.persistence.mapper.MilitaryStrengthRegistrationMapper;
import org.springframework.beans.BeanUtils;
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

    public List<MilitaryStrengthPlan> getMilitaryStrengthPlan(String planName,String type,String identity){
        return militaryStrengthPlanMapper.findPlanNameAndType(planName,type,identity);
    }
    public void addMilitaryStrengthPlan(AddMilitaryStrengthPlanRequest request){
        MilitaryStrengthPlan militaryStrengthPlan = new MilitaryStrengthPlan();
        BeanUtils.copyProperties(request,militaryStrengthPlan);
        militaryStrengthPlanMapper.insert(militaryStrengthPlan);

    }

    /**
     * 兵力动用登记表
     * @param requiredBy
     * @param taskType
     * @param concreteTask
     * @param identity
     * @return
     */
    public List<MilitaryStrengthRegistration> getMilitaryStrengthRegistration(String requiredBy ,String taskType,String concreteTask,String identity){
        return militaryStrengthRegistrationMapper.findRequiredByAndTaskTypeAndConcreteTask(requiredBy, taskType, concreteTask, identity);
    }
    public void addMilitaryStrengthRegistration(AddMilitaryStrengthRegistrationRequest request){
        MilitaryStrengthRegistration militaryStrengthRegistration = new MilitaryStrengthRegistration();
        BeanUtils.copyProperties(request,militaryStrengthRegistration);
        militaryStrengthRegistrationMapper.insert(militaryStrengthRegistration);
    }
    /**
     * 兵力动用相关保障表
     */
    public List<MilitaryStrengthGuarantee>getMilitaryStrengthGuarantee(String registrationTask,String registrationPerson,String identity){
        return militaryStrengthGuranteeMapper.findRegistrationTaskAndRegistrationPerson(registrationTask, registrationPerson, identity);
    }
    public void addMilitaryStrengthGuarantee(AddMilitaryStrengthGuaranteeRequest request){
        MilitaryStrengthGuarantee militaryStrengthGuarantee = new MilitaryStrengthGuarantee();
        BeanUtils.copyProperties(request,militaryStrengthGuarantee);
        militaryStrengthGuranteeMapper.insert(militaryStrengthGuarantee);
    }

}