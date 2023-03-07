package com.endpoint;


import com.model.BaseResponse;
import com.model.request.*;
import com.persistence.entity.ArmsEquipmentRegistration;
import com.persistence.entity.EmergencyEquipmentRegistration;
import com.persistence.entity.MilitaryAndCivilianEquipmentRegistration;
import com.persistence.entity.MilitaryServiceRegistration;
import com.service.EquipmentSupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
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


    /**
     * 增加一条武器装备登记表记录
     * @param request
     * @return
     */
    @PostMapping("/add_arms_equipment_registration")
    public BaseResponse<Boolean> addArmsEquipmentRegistration(@RequestBody AddArmsEquipmentRegistrationRequest request){
        try {
            //校验参数
            if(ObjectUtils.isEmpty(request.getEquipmentName())){
                return BaseResponse.failed("参数校验不通过！");
            }

            List<ArmsEquipmentRegistration> armsEquipmentRegistrations = service.getArmsEquipmentRegistration(request.getEquipmentName(), request.getType(), request.getIdentity());
            if (!armsEquipmentRegistrations.isEmpty()) {
                return BaseResponse.failed("不能添加重复数据！");
            }
            // 如果在查询数据库后发现没有该数据,则增加该数据项
            service.addArmsEquipmentRegistration(request);
            return BaseResponse.ok();
        }catch (Exception e){
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

    /**
     * 增加一条应急专用装备登记表记录
     * @param request
     * @return
     */
   @PostMapping("/add_emergency_equipment_registration")
    public BaseResponse<Boolean> addEmergencyEquipmentRegistration(@RequestBody AddEmergencyEquipmentRegistrationRequest request){
        try {
            //校验参数
            if(ObjectUtils.isEmpty(request.getEquipmentName())){
                return BaseResponse.failed("参数校验不通过！");
            }

            List<EmergencyEquipmentRegistration> emergencyEquipmentRegistrations = service.getEmergencyEquipmentRegistration(request.getEquipmentName(), request.getType(), request.getIdentity());
            if (!emergencyEquipmentRegistrations.isEmpty()) {
                return BaseResponse.failed("不能添加重复数据！");
            }
            // 如果在查询数据库后发现没有该数据,则增加该数据项
            service.AddEmergencyEquipmentRegistration(request);
            return BaseResponse.ok();
        }catch (Exception e){
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }
    @PostMapping("/add_military_and_civilian_equipment_registration")
    public BaseResponse<Boolean> addMilitaryAndCivilianEquipmentRegistration(@RequestBody AddMilitaryAndCivilianEquipmentRegistrationRequest request){
        try {

            //校验参数
            if(ObjectUtils.isEmpty(request.getEquipmentName())){
                return BaseResponse.failed("参数校验不通过！");
            }

            List<MilitaryAndCivilianEquipmentRegistration> militaryAndCivilianEquipmentRegistrations = service.getMilitaryAndCivilianEquipmentRegistration(request.getEquipmentName(), request.getType(), request.getIdentity());
            if (!militaryAndCivilianEquipmentRegistrations.isEmpty()) {
                return BaseResponse.failed("不能添加重复数据！");
            }
            // 如果在查询数据库后发现没有该数据,则增加该数据项
            service.addMilitaryAndCivilianEquipmentRegistration(request);
            return BaseResponse.ok();
        }catch (Exception e){
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

}
