package com.endpoint;


import com.model.BaseResponse;
import com.model.request.*;
import com.persistence.entity.MilitaryStrengthGuarantee;
import com.persistence.entity.MilitaryStrengthPlan;
import com.persistence.entity.MilitaryStrengthRegistration;
import com.service.TroopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 兵力动用
 *
 * @author wuyuxiao
 */
@RestController
@RequestMapping("/api")
public class TroopController {


    @Autowired
    private TroopService service;

    /**
     * 训练任务详情表分页接口
     *
     * @param request
     * @return
     */
    @PostMapping("/page_query_military_strength_plan")
    public BaseResponse<BasePageQueryResponse<MilitaryStrengthPlan>> pageQueryMilitaryStrengthPlan(@RequestBody PageQueryMilitaryStrengthPlanRequest request) {
        try {

            //1.分页查询
            List<MilitaryStrengthPlan> list = service.pageQueryPlan(request);

            //2.查询总记录数
            int count = service.queryPlanTotalCount(request);

            return BaseResponse.ok(new BasePageQueryResponse<>(list, count));
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

    /**
     * 训练任务详情表分页接口
     *
     * @param request
     * @return
     */
    @PostMapping("/page_query_military_strength_guarantee")
    public BaseResponse<BasePageQueryResponse<MilitaryStrengthGuarantee>> pageQueryMilitaryStrengthGuarantee(@RequestBody PageQueryMilitaryStrengthGuaranteeRequest request) {
        try {

            //1.分页查询
            List<MilitaryStrengthGuarantee> list = service.pageQueryGuarantee(request);

            //2.查询总记录数
            int count = service.queryGuaranteeTotalCount(request);

            return BaseResponse.ok(new BasePageQueryResponse<>(list, count));
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

    /**
     * 训练任务详情表分页接口
     *
     * @param request
     * @return
     */
    @PostMapping("/page_query_military_strength_registration")
    public BaseResponse<BasePageQueryResponse<MilitaryStrengthRegistration>> pageQueryMilitaryStrengthRegistration(@RequestBody PageQueryMilitaryStrengthRegistrationRequest request) {
        try {

            //1.分页查询
            List<MilitaryStrengthRegistration> list = service.pageQueryRegistration(request);

            //2.查询总记录数
            int count = service.queryRegistrationTotalCount(request);

            return BaseResponse.ok(new BasePageQueryResponse<>(list, count));
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }


    /**
     * 增加一条兵力动用计划表记录
     * @param request
     * @return
     */
    @PostMapping("/add_military_strength_plan")
    public BaseResponse<Boolean> addMilitaryStrengthPlan(@RequestBody AddMilitaryStrengthPlanRequest request){
        try {
            //校验参数
            if(ObjectUtils.isEmpty(request.getPlanName())||ObjectUtils.isEmpty(request.getType())){
                return BaseResponse.failed("参数校验不通过！");
            }
            List<MilitaryStrengthPlan>militaryStrengthPlans =service.getMilitaryStrengthPlan(request.getPlanName(), request.getType(), request.getIdentity());
            if (!militaryStrengthPlans.isEmpty()) {
                return BaseResponse.failed("不能添加重复数据！");
            }
            service.addMilitaryStrengthPlan(request);
            return BaseResponse.ok();
        }catch (Exception e){
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

    /**
     * 增加一条兵力动用登记表记录
     * @param request
     * @return
     */
    @PostMapping("/add_military_strength_registration")
    public BaseResponse<Boolean> addMilitaryStrengthRegistration(@RequestBody AddMilitaryStrengthRegistrationRequest request){
        try{
            //校验参数
            if(ObjectUtils.isEmpty(request.getRequiredBy())||ObjectUtils.isEmpty(request.getTaskType())||ObjectUtils.isEmpty(request.getConcreteTask())){
                return BaseResponse.failed("参数校验不通过！");
            }
            List<MilitaryStrengthRegistration>militaryStrengthRegistrations =service.getMilitaryStrengthRegistration(request.getRequiredBy(), request.getTaskType(), request.getConcreteTask(), request.getIdentity());
            if (!militaryStrengthRegistrations.isEmpty()) {
                return BaseResponse.failed("不能添加重复数据！");
            }
            service.addMilitaryStrengthRegistration(request);
            return BaseResponse.ok();
        }catch (Exception e){
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }
    @PostMapping("/add_military_strength_guarantee")
    public BaseResponse<Boolean> addMilitaryStrengthGuarantee(@RequestBody AddMilitaryStrengthGuaranteeRequest request){
        try {
            //校验参数
            if(ObjectUtils.isEmpty(request.getRegistrationPerson())||ObjectUtils.isEmpty(request.getRegistrationTask().isEmpty())){
                return BaseResponse.failed("参数校验不通过！");
            }
            // 判重
            List<MilitaryStrengthGuarantee> militaryStrengthGuarantees=service.getMilitaryStrengthGuarantee(request.getRegistrationTask(), request.getRegistrationPerson(), request.getIdentity());
            if (!militaryStrengthGuarantees.isEmpty()) {
                return BaseResponse.failed("不能添加重复数据！");
            }
            // 插入一行新数据
            service.addMilitaryStrengthGuarantee(request);
            return BaseResponse.ok();
        }catch (Exception e){
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

}
