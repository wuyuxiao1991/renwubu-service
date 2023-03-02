package com.service;


import com.model.request.AddTrainingMissionDetailsRequest;

import com.model.request.AddYearlyPlanDetailRequest;
import com.model.request.PageQueryTrainingDetailsRequest;
import com.model.request.PageQueryYearlyPlanDetailsRequest;
import com.persistence.entity.TrainingMissionDetails;
import com.persistence.entity.YearlyPlanDetails;
import com.persistence.mapper.TrainingMissionDetailMapper;
import com.persistence.mapper.YearlyPlanDetailsMapper;
import org.springframework.beans.BeanUtils;
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
    /* 控制数据的传输,获取teamType 和teamBranchName，还有identity*/
    public List<TrainingMissionDetails> getTrainingMissionDetail(String teamType,String teamBranchName,String identity){
        // 返回的内容是什么：就是select的查询结果集合，传递的参数也是select是否需要的参数
        return trainingMissionMapper.findByTeamTypeAndTeamBranchNameAndIdentity(teamType,teamBranchName,identity);
    }

    /**
     * 插入数据
     */
    public void addTrainingTaskDetail(AddTrainingMissionDetailsRequest request){
        // 为什么要实例化这个类，这个类的作用是什么？这个类对应的是与数据库中的字段，相当于这个就是DAO层
        TrainingMissionDetails trainingMissionDetails = new TrainingMissionDetails();
        // BeanUtils的这个类又是什么作用
        BeanUtils.copyProperties(request,trainingMissionDetails);
        trainingMissionMapper.insert(trainingMissionDetails);
    }
    /**
     * 年度计划表,获取传入年度计划表中的year，month，teamBranch的字段值是否在表中已经存在
     */
    public List<YearlyPlanDetails> getYearlyPlanDetails(String year,String month,String teamBranch,String identity){
        return yearlyPlanDetailsMapper.findYearMonthAndTeamBranch(year,month,teamBranch,identity);
    }
    public void addYearlyPlanDetail(AddYearlyPlanDetailRequest request){
        // 想想为什么要实例化这个YearlyPlanDetails,就是要获取与表单字段相对应的类
        YearlyPlanDetails yearlyPlanDetails = new YearlyPlanDetails();
        // 为什么要使用BeanUtils.copyProperties这个方法呢，使用这个方法的作用就是对JavaBean的set方法赋值
        /*
        这里我用传统方法写一下：
        request.setYear(yearlyPlanDetails.year)
        request.setMonth(yearlyPlanDetails.month)
        ...
        然后就是调用JDBC或操作Hibernate 持久化对象User到数据库
         */
        BeanUtils.copyProperties(request,yearlyPlanDetails);
        // insert方法在那里实现的
        yearlyPlanDetailsMapper.insert(yearlyPlanDetails);
    }
}