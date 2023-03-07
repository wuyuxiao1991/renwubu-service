package com.endpoint;


import com.model.BaseResponse;
import com.model.request.*;
import com.persistence.entity.BaseArmedInstitutionRegistration;
import com.persistence.entity.MinbingLeaderRegistration;
import com.persistence.entity.PreBuildPartyOrganization;
import com.persistence.entity.ZhuanwuLeaderRegistration;
import com.service.PoliticalWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 政治工作
 *
 * @author wuyuxiao
 */
@RestController
@RequestMapping("/api")
public class PoliticalWorkController {
    @Autowired
    private PoliticalWorkService politicalWorkService;

    /**
     * 预建党组织编建表分页接口
     *
     * @param request
     * @return
     */
    @PostMapping("/page_query_pre_build_party_organization")
    public BaseResponse<BasePageQueryResponse<PreBuildPartyOrganization>> pageQueryPreBuildPartyOrganization(@RequestBody PageQueryPreBuildPartyOrganizationRequest request) {
        try {

            //1.分页查询
            List<PreBuildPartyOrganization> list = politicalWorkService.pageQueryPreBuildPartyOrganization(request);

            //2.查询总记录数
            int count = politicalWorkService.queryPreBuildPartyOrganizationTotalCount(request);

            return BaseResponse.ok(new BasePageQueryResponse<>(list, count));
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }


    /**
     * 基层武装机构登记表分页接口
     *
     * @param request
     * @return
     */
    @PostMapping("/page_query_base_armed_institution_registration")
    public BaseResponse<BasePageQueryResponse<BaseArmedInstitutionRegistration>> pageQueryBaseArmedInstitutionRegistration(@RequestBody PageQueryBaseArmedInstitutionRegistrationRequest request) {
        try {

            //1.分页查询
            List<BaseArmedInstitutionRegistration> list = politicalWorkService.pageQueryBaseArmedInstitutionRegistration(request);

            //2.查询总记录数
            int count = politicalWorkService.queryBaseArmedInstitutionRegistrationTotalCount(request);

            return BaseResponse.ok(new BasePageQueryResponse<>(list, count));
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

    /**
     * 专武干部登记表分页接口
     *
     * @param request
     * @return
     */
    @PostMapping("/page_query_zhuanwu_leader_registration")
    public BaseResponse<BasePageQueryResponse<ZhuanwuLeaderRegistration>> pageQueryZhuanWuLeaderRegistration(@RequestBody PageQueryZhuanwuLeaderRegistrationRequest request) {
        try {

            //1.分页查询
            List<ZhuanwuLeaderRegistration> list = politicalWorkService.pageQueryzhuanwuLeaderRegistration(request);

            //2.查询总记录数
            int count = politicalWorkService.queryZhuanwuLeaderRegistrationTotalCount(request);

            return BaseResponse.ok(new BasePageQueryResponse<>(list, count));
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

    /**
     * 民兵干部登记表分页接口
     *
     * @param request
     * @return
     */
    @PostMapping("/page_query_minbing_leader_registration")
    public BaseResponse<BasePageQueryResponse<MinbingLeaderRegistration>> pageQueryMinbingLeaderRegistration(@RequestBody PageQueryMinBingLeaderRegistrationRequest request) {
        try {

            //1.分页查询
            List<MinbingLeaderRegistration> list = politicalWorkService.pageQueryMinbingLeaderRegistration(request);

            //2.查询总记录数
            int count = politicalWorkService.queryMinbingLeaderRegistrationTotalCount(request);

            return BaseResponse.ok(new BasePageQueryResponse<>(list, count));
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }


    /**
     * 新增一条预建党组织编建表方法
     * @param request
     * @return
     */
    @PostMapping("/add_pre_build_party_organization")
    public BaseResponse<Boolean> addPreBuildPartyOrganization(@RequestBody AddPreBuildPartyOrganizationRequest request){
        try {
            //校验参数
            if(ObjectUtils.isEmpty(request.getPartyOrganizationName())){
                return BaseResponse.failed("参数校验不通过！");
            }
            List<PreBuildPartyOrganization> preBuildPartyOrganizations = politicalWorkService.getPreBuildPartyOrganization(request.getPartyOrganizationName(),request.getIdentity());
            if (!preBuildPartyOrganizations.isEmpty()) {
                return BaseResponse.failed("不能添加重复数据！");
            }
            // 如果发现没有此数据则插入一条
            politicalWorkService.addPreBuildPartyOrganization(request);
            return BaseResponse.ok();
        }catch (Exception e){
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

    /**
     * 新增一条基层武装机构登记表的方法
     * @param request
     * @return
     */
    @PostMapping("/add_base_armed_institution_registration")
    public BaseResponse<Boolean> addBaseArmedInstitutionRegistration(@RequestBody AddBaseArmedInstitutionRegistrationRequest request){
        try {
            //校验参数
            if(ObjectUtils.isEmpty(request.getName())||ObjectUtils.isEmpty(request.getType())){
                return BaseResponse.failed("参数校验不通过！");
            }
            // 判重
            List<BaseArmedInstitutionRegistration> baseArmedInstitutionRegistrations = politicalWorkService.getBaseArmedInstitutionRegistration(request.getName(), request.getType(),  request.getIdentity());
            if (!baseArmedInstitutionRegistrations.isEmpty()) {
                return BaseResponse.failed("不能添加重复数据！");
            }
            // 增加数据
            politicalWorkService.addBaseArmedInstitutionRegistration(request);
            return BaseResponse.ok();
        }catch (Exception e){
            return BaseResponse.failed(e.getLocalizedMessage());

        }
    }

    /**
     * 新增一条专武干部登记表
     * @param request
     * @return
     */
    @PostMapping("/add_zhuanwu_leader_registration")
    public BaseResponse<Boolean> addZhuanwuLeaderRegistration(@RequestBody AddZhuanwuLeaderRegistrationRequest request){
        try {
            //校验参数
            if(ObjectUtils.isEmpty(request.getIdNumber())){
                return BaseResponse.failed("参数校验不通过！");
            }
            // 判重
            List<ZhuanwuLeaderRegistration> zhuanwuLeaderRegistrations = politicalWorkService.getZhuanwuLeaderRegistration(request.getIdNumber(),  request.getIdentity());
            if (!zhuanwuLeaderRegistrations.isEmpty()) {
                return BaseResponse.failed("不能添加重复数据！");
            }
            // 增加数据
            politicalWorkService.addZhuanwuLeaderRegistration(request);
            return BaseResponse.ok();
        }catch (Exception e){
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }
    @PostMapping("/add_minbing_leader_registration")
    public BaseResponse<Boolean> addMingbingLeaderRegistration(@RequestBody AddMinbingLeaderRegistrationRequest request){
        try{
            //校验参数
            if(ObjectUtils.isEmpty(request.getName())){
                return BaseResponse.failed("参数校验不通过！");
            }

            List<MinbingLeaderRegistration> minbingLeaderRegistrations=politicalWorkService.getMinbingLeaderRegistration(request.getWork(), request.getPosition(), request.getName(), request.getPoliticalStatus(), request.getPhone(), request.getTeamNameAndPosition(), request.getIdentity());
            if (!minbingLeaderRegistrations.isEmpty()) {
                return BaseResponse.failed("不能添加重复数据！");
            }
            // 增加一条
            politicalWorkService.addMinbingLeaderRegistration(request);
            return BaseResponse.ok();
        }catch (Exception e){
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }
}
