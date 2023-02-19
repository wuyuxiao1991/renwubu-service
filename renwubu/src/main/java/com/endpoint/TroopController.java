package com.endpoint;


import com.model.BaseResponse;
import com.model.request.BasePageQueryResponse;
import com.model.request.PageQueryMilitaryStrengthGuaranteeRequest;
import com.model.request.PageQueryMilitaryStrengthPlanRequest;
import com.model.request.PageQueryMilitaryStrengthRegistrationRequest;
import com.persistence.entity.MilitaryStrengthGuarantee;
import com.persistence.entity.MilitaryStrengthPlan;
import com.persistence.entity.MilitaryStrengthRegistration;
import com.service.TroopService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
