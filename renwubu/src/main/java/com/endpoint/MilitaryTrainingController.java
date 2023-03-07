package com.endpoint;


import com.model.BaseResponse;
import com.model.request.*;
import com.persistence.entity.TrainingMissionDetails;
import com.persistence.entity.YearlyPlanDetails;
import com.service.MilitaryTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 军事训练
 *
 * @author wuyuxiao
 */
@RestController
@RequestMapping("/api")
public class MilitaryTrainingController {


   @Autowired
   private MilitaryTrainingService militaryTrainingService;

    /**
     * 训练任务详情表分页接口
     * @param request
     * @return
     */
    @PostMapping("/page_query_training_details")
    public BaseResponse<BasePageQueryResponse<TrainingMissionDetails>> pageQueryTrainingDetails(@RequestBody PageQueryTrainingDetailsRequest request) {
        try {

            //1.分页查询
            List<TrainingMissionDetails> list = militaryTrainingService.pageQueryTrainingMissionDetails(request);

            //2.查询总记录数
            int count = militaryTrainingService.queryTrainingMissionDetailsTotalCount(request);

            return BaseResponse.ok(new BasePageQueryResponse<>(list, count));
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

    /**
     * 年度计划详情表分页接口
     * @param request
     * @return
     */
    @PostMapping("/page_query_yearly_plan_details")
    public BaseResponse<BasePageQueryResponse<YearlyPlanDetails>> pageQueryYearlyPlanDetails(@RequestBody PageQueryYearlyPlanDetailsRequest request) {
        try {

            //1.分页查询
            List<YearlyPlanDetails> list = militaryTrainingService.pageQueryYearlyPanDetail(request);

            //2.查询总记录数
            int count = militaryTrainingService.queryYearlyPanDetailTotalCount(request);

            return BaseResponse.ok(new BasePageQueryResponse<>(list, count));
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

    /**
     * 新增一条训练任务详情表记录
     */
    //PsstMapping 是Spring MVC用来标注处理HTTP POST请求的注解，也就是告诉控制器这个方法是用来处理Post请求的
    @PostMapping("/add_training_mission_details")
    public BaseResponse<Boolean> addTrainingMissionDetails(@RequestBody AddTrainingMissionDetailsRequest request){
        try {

            //校验参数
            if(ObjectUtils.isEmpty(request.getProvince())||ObjectUtils.isEmpty(request.getTeamBranchName())){
                return BaseResponse.failed("参数校验不通过！");
            }
            // 判重
            List<TrainingMissionDetails> trainingMissionDetails = militaryTrainingService.getTrainingMissionDetail(request.getProvince(),request.getTeamBranchName(), request.getIdentity());
            // 判断集合对象是否为非空，因为如果查询到结果集合就说明在文档中已经存在了该字段，为空就说明在表格中还没有该字段
            if (!trainingMissionDetails.isEmpty()) {
                return BaseResponse.failed("不能添加重复数据！");
            }
            // 新增
            militaryTrainingService.addTrainingTaskDetail(request);
            return BaseResponse.ok();
        }catch (Exception e){
            return BaseResponse.failed(e.getLocalizedMessage());
        }

    }

    @PostMapping("/add_yearly_plan_details")
    public BaseResponse<Boolean> addYearlyPlanDetails(@RequestBody AddYearlyPlanDetailRequest request){
        // 获取是否重复的结果集
        try {
            //校验参数
            if(ObjectUtils.isEmpty(request.getTeamBranch())||ObjectUtils.isEmpty(request.getYear())||ObjectUtils.isEmpty(request.getMonth())){
                return BaseResponse.failed("参数校验不通过！");
            }

            List<YearlyPlanDetails> yearlyPlanDetails = militaryTrainingService.getYearlyPlanDetails(request.getYear(), request.getMonth(), request.getTeamBranch(), request.getIdentity());
            if (!yearlyPlanDetails.isEmpty()) {
                return BaseResponse.failed("不能添加重复数据！");
            }
            // 如果在查询数据库后发现没有该数据,则增加该数据项
            militaryTrainingService.addYearlyPlanDetail(request);
            return BaseResponse.ok();
        }catch (Exception e){
            return BaseResponse.failed(e.getLocalizedMessage());
        }

    }
}
