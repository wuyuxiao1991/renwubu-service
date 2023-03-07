package com.endpoint;


import com.model.BaseResponse;
import com.model.request.*;
import com.persistence.entity.*;
import com.service.OrganizationBuildService;
import com.service.PotentialCheckService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
