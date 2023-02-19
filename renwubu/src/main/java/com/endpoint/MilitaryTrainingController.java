package com.endpoint;


import com.model.BaseResponse;
import com.model.request.BasePageQueryResponse;
import com.model.request.PageQueryTrainingDetailsRequest;
import com.model.request.PageQueryYearlyPlanDetailsRequest;
import com.persistence.entity.TrainingMissionDetails;
import com.persistence.entity.YearlyPlanDetails;
import com.service.MilitaryTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
