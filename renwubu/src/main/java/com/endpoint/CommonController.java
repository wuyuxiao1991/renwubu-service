package com.endpoint;


import com.model.BaseResponse;
import com.model.request.DeleteItemRequest;
import com.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 兵役服务
 *
 * @author wuyuxiao
 */
@RestController
@RequestMapping("/api")
public class CommonController {

    @Autowired
    private CommonService commonService;

    /**
     * 删除
     * @param request
     * @return
     */
    @PostMapping("/delete_item")
    public BaseResponse<Boolean> deleteItem(@RequestBody DeleteItemRequest request) {
        try {
            commonService.deleteItem(request);

            return BaseResponse.ok(true);
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }
}
