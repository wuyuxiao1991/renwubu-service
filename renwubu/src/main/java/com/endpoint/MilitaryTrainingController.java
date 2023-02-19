package com.endpoint;


import com.model.BaseResponse;
import com.model.request.BasePageQueryResponse;
import com.model.request.PageQueryTrainingDetailsRequest;
import com.persistence.entity.TrainingMissionDetails;
import com.service.TrainingMissionService;
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
   private TrainingMissionService trainingMissionService;

    /**
     * 训练任务详情表分页接口
     * @param request
     * @return
     */
    @PostMapping("/page_query_training_details")
    public BaseResponse<BasePageQueryResponse<TrainingMissionDetails>> pageQueryTrainingDetails(@RequestBody PageQueryTrainingDetailsRequest request) {
        try {

            //1.分页查询
            List<TrainingMissionDetails> list = trainingMissionService.pageQuery(request);

            //2.查询总记录数
            int count = trainingMissionService.queryTotalCount(request);

            return BaseResponse.ok(new BasePageQueryResponse<>(list, count));
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }
}
