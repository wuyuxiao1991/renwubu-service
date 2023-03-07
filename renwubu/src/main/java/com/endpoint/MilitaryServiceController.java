package com.endpoint;


import com.model.BaseResponse;
import com.model.request.AddMilitaryServiceRegistrationRequest;
import com.model.request.BasePageQueryResponse;
import com.model.request.PageQueryMilitaryCivilizationEquipmentRequest;
import com.model.request.PageQueryMilitaryServiceRegistrationRequest;
import com.persistence.entity.MilitaryAndCivilianEquipmentRegistration;
import com.persistence.entity.MilitaryServiceRegistration;
import com.service.MilitaryServiceService;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 兵役服务
 *
 * @author wuyuxiao
 */
@RestController
@RequestMapping("/api")
public class MilitaryServiceController {

    @Autowired
    private MilitaryServiceService service;

    /**
     * 兵役登记表分页接口
     *
     * @param request
     * @return
     */
    @PostMapping("/page_query_military_service_registration")
    public BaseResponse<BasePageQueryResponse<MilitaryServiceRegistration>> pageQueryMilitaryServiceRegistration(@RequestBody PageQueryMilitaryServiceRegistrationRequest request) {
        try {

            //1.分页查询
            List<MilitaryServiceRegistration> list = service.pageQuery(request);

            //2.查询总记录数
            int count = service.queryTotalCount(request);

            return BaseResponse.ok(new BasePageQueryResponse<>(list, count));
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

    @PostMapping("/add_military_service_registration")
    public BaseResponse<Boolean> addMilitaryServiceRegistration(@RequestBody AddMilitaryServiceRegistrationRequest request){
        try {
            //校验参数
            if(ObjectUtils.isEmpty(request.getIdentity())){
                return BaseResponse.failed("参数校验不通过！");
            }

            List<MilitaryServiceRegistration> militaryServiceRegistrations = service.getMilitaryServiceRegistration(request.getIdNumber(), request.getIdentity());
            if (!militaryServiceRegistrations.isEmpty()) {
                return BaseResponse.failed("不能添加重复数据！");
            }
            // 如果在查询数据库后发现没有该数据,则增加该数据项
            service.addMilitaryServiceRegistration(request);
            return BaseResponse.ok();
        }catch (Exception e){
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }
}
