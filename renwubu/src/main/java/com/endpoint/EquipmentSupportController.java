package com.endpoint;


import com.model.BaseResponse;
import com.model.request.BasePageQueryResponse;
import com.model.request.PageQueryArmsEquipmentRegistrationRequest;
import com.model.request.PageQueryEmergencyEquipmentRegistrationRequest;
import com.model.request.PageQueryMilitaryCivilizationEquipmentRequest;
import com.persistence.entity.ArmsEquipmentRegistration;
import com.persistence.entity.EmergencyEquipmentRegistration;
import com.persistence.entity.MilitaryAndCivilianEquipmentRegistration;
import com.service.EquipmentSupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 装备保障
 *
 * @author wuyuxiao
 */
@RestController
@RequestMapping("/api")
public class EquipmentSupportController {

    @Autowired
    private EquipmentSupportService service;


    /**
     * 武器装备登记表分页接口
     *
     * @param request
     * @return
     */
    @PostMapping("/page_query_arms_equipment_registration")
    public BaseResponse<BasePageQueryResponse<ArmsEquipmentRegistration>> pageQueryArmsEquipmentRegistration(@RequestBody PageQueryArmsEquipmentRegistrationRequest request) {
        try {

            //1.分页查询
            List<ArmsEquipmentRegistration> list = service.pageQuery(request);

            //2.查询总记录数
            int count = service.queryTotalCount(request);

            return BaseResponse.ok(new BasePageQueryResponse<>(list, count));
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

    /**
     * 应急装备登记表分页接口
     *
     * @param request
     * @return
     */
    @PostMapping("/page_query_emergency_equipment_registration")
    public BaseResponse<BasePageQueryResponse<EmergencyEquipmentRegistration>> pageQueryEmergencyEquipmentRegistration(@RequestBody PageQueryEmergencyEquipmentRegistrationRequest request) {
        try {

            //1.分页查询
            List<EmergencyEquipmentRegistration> list = service.pageQuery(request);

            //2.查询总记录数
            int count = service.queryTotalCount(request);

            return BaseResponse.ok(new BasePageQueryResponse<>(list, count));
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

    /**
     * 军民通用装备表分页接口
     *
     * @param request
     * @return
     */
    @PostMapping("/page_query_military_civilization_equipment")
    public BaseResponse<BasePageQueryResponse<MilitaryAndCivilianEquipmentRegistration>> pageQueryMilitaryCivilizationEquipment(@RequestBody PageQueryMilitaryCivilizationEquipmentRequest request) {
        try {

            //1.分页查询
            List<MilitaryAndCivilianEquipmentRegistration> list = service.pageQuery(request);

            //2.查询总记录数
            int count = service.queryTotalCount(request);

            return BaseResponse.ok(new BasePageQueryResponse<>(list, count));
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }
}
