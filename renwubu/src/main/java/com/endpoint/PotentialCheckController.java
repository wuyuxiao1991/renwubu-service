package com.endpoint;


import com.model.BaseResponse;
import com.model.request.*;
import com.persistence.entity.*;
import com.service.OrganizationBuildService;
import com.service.PotentialCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 潜力核查
 *
 * @author wuyuxiao
 */
@RestController
@RequestMapping("/api")
public class PotentialCheckController {
    @Autowired
    private PotentialCheckService potentialCheckService;

    @PostMapping("/page_query_people_potential")
    public BaseResponse<BasePageQueryResponse<PeoplePotentialRegistration>> pageQueryPeopleDetail(@RequestBody PageQueryPeoplePotentialRequest request) {
        try {

            //1.分页查询
            List<PeoplePotentialRegistration> list = potentialCheckService.pageQueryPeoplePotential(request);

            //2.查询总记录数
            int count = potentialCheckService.queryPeoplePotentialTotalCount(request);

            return BaseResponse.ok(new BasePageQueryResponse<>(list, count));
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }


    @PostMapping("/page_query_company_potential")
    public BaseResponse<BasePageQueryResponse<CompanyPotentialRegistration>> pageQueryCompanyDetail(@RequestBody PageQueryCompanyPotentialRequest request) {
        try {

            //1.分页查询
            List<CompanyPotentialRegistration> list = potentialCheckService.pageQueryCompanyPotential(request);

            //2.查询总记录数
            int count = potentialCheckService.queryCompanyPotentialTotalCount(request);

            return BaseResponse.ok(new BasePageQueryResponse<>(list, count));
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

    @PostMapping("/page_query_equipment_potential")
    public BaseResponse<BasePageQueryResponse<EquipmentPotentialRegistration>> pageQueryEquipmentDetail(@RequestBody PageQueryEquipmentPotentialRequest request) {
        try {

            //1.分页查询
            List<EquipmentPotentialRegistration> list = potentialCheckService.pageQueryEquipmentPotential(request);

            //2.查询总记录数
            int count = potentialCheckService.queryEquipmentPotentialTotalCount(request);

            return BaseResponse.ok(new BasePageQueryResponse<>(list, count));
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }


    /**
     * 新增一条人员详情表的方法
     * @param request
     * @return
     */
    @PostMapping("/add_people_potential")
    public BaseResponse<Boolean> addPeoplePotentialRegistration(@RequestBody AddPeoplePotentialRegistrationRequest request){
        try {
            //校验参数
            if(ObjectUtils.isEmpty(request.getName())||ObjectUtils.isEmpty(request.getIdNumber())){
                return BaseResponse.failed("名称、身份证号不可为空！");
            }
            // 判重
            List<PeoplePotentialRegistration> baseArmedInstitutionRegistrations = potentialCheckService.getPeoplePotentialRegistration(request);
            if (!baseArmedInstitutionRegistrations.isEmpty()) {
                return BaseResponse.failed("不能添加重复数据！");
            }
            // 增加数据
            potentialCheckService.addPeoplePotentialRegistration(request);
            return BaseResponse.ok();
        }catch (Exception e){
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

    /**
     * 新增一条公司详情登记表的方法
     * @param request
     * @return
     */
    @PostMapping("/add_company_potential")
    public BaseResponse<Boolean> addCompanyPotentialRegistration(@RequestBody AddCompanyPotentialRegistrationRequest request){
        try {
            //校验参数
            if(ObjectUtils.isEmpty(request.getName())){
                return BaseResponse.failed("名称不可为空！");
            }
            // 判重
            List<CompanyPotentialRegistration> companyPotentialRegistrations = potentialCheckService.getCompanyPotentialRegistration(request);
            if (!companyPotentialRegistrations.isEmpty()) {
                return BaseResponse.failed("不能添加重复数据！");
            }
            // 增加数据
            potentialCheckService.addCompanyPotentialRegistration(request);
            return BaseResponse.ok();
        }catch (Exception e){
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

    /**
     * 新增一条装备详情登记表的方法
     * @param request
     * @return
     */
    @PostMapping("/add_equipment_potential")
    public BaseResponse<Boolean> addEquipmentPotentialRegistration(@RequestBody AddEquipmentPotentialRegistrationRequest request){
        try {
            //校验参数
            if(ObjectUtils.isEmpty(request.getName())||ObjectUtils.isEmpty(request.getStoragePlace())){
                return BaseResponse.failed("名称和存储地点不可为空！");
            }
            // 判重
            List<EquipmentPotentialRegistration> equipmentPotentialRegistration = potentialCheckService.getEquipmentPotentialRegistration(request);
            if (!equipmentPotentialRegistration.isEmpty()) {
                return BaseResponse.failed("不能添加重复数据！");
            }
            // 增加数据
            potentialCheckService.addEquipmentPotentialRegistration(request);
            return BaseResponse.ok();
        }catch (Exception e){
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }
}
