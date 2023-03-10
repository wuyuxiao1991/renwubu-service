package com.service;


import com.model.request.*;
import com.persistence.entity.BaseArmedInstitutionRegistration;
import com.persistence.entity.MinbingLeaderRegistration;
import com.persistence.entity.PreBuildPartyOrganization;
import com.persistence.entity.ZhuanwuLeaderRegistration;
import com.persistence.mapper.BaseArmedInstitutionRegistrationMapper;
import com.persistence.mapper.MinbingLeaderRegistrationMapper;
import com.persistence.mapper.PreBuildPartyOrganizationMapper;
import com.persistence.mapper.ZhuanwuLeaderRegistrationMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuyuxiao
 */
@Service
public class PoliticalWorkService {
    @Resource
    private PreBuildPartyOrganizationMapper preBuildPartyOrganizationMapper;

    @Resource
    private BaseArmedInstitutionRegistrationMapper baseArmedInstitutionRegistrationMapper;

    @Resource
    private ZhuanwuLeaderRegistrationMapper zhuanwuLeaderRegistrationMapper;

    @Resource
    private MinbingLeaderRegistrationMapper minbingLeaderRegistrationMapper;


    public List<PreBuildPartyOrganization> pageQueryPreBuildPartyOrganization(PageQueryPreBuildPartyOrganizationRequest request) {
        return preBuildPartyOrganizationMapper.pageQuery(request.getSearchKey(), request.getPartyOrganizationName(),
                request.getIdentity(), (request.getPageNumber() - 1) * request.getPageSize(), request.getPageSize());
    }


    public int queryPreBuildPartyOrganizationTotalCount(PageQueryPreBuildPartyOrganizationRequest request) {
        return preBuildPartyOrganizationMapper.queryTotalCount(request.getSearchKey(), request.getPartyOrganizationName(), request.getIdentity());
    }


    public List<BaseArmedInstitutionRegistration> pageQueryBaseArmedInstitutionRegistration(PageQueryBaseArmedInstitutionRegistrationRequest request) {
        return baseArmedInstitutionRegistrationMapper.pageQuery(request.getSearchKey(), request.getName(), request.getType(), request.getPlace(), request.getApprovalBy(), request.getLevel(),
                request.getManagementRelation(), request.getRegionDistribution(), request.getIdentity(), (request.getPageNumber() - 1) * request.getPageSize(), request.getPageSize());
    }

    public int queryBaseArmedInstitutionRegistrationTotalCount(PageQueryBaseArmedInstitutionRegistrationRequest request) {
        return baseArmedInstitutionRegistrationMapper.queryTotalCount(request.getSearchKey(), request.getName(), request.getType(), request.getPlace(), request.getApprovalBy(), request.getLevel(),
                request.getManagementRelation(), request.getRegionDistribution(), request.getIdentity());
    }

    public List<ZhuanwuLeaderRegistration> pageQueryzhuanwuLeaderRegistration(PageQueryZhuanwuLeaderRegistrationRequest request) {
        return zhuanwuLeaderRegistrationMapper.pageQuery(request.getSearchKey(), request.getName(), request.getPosition(), request.getPoliticalStatus(), request.getEducationLevel(), request.getPhone(),
                request.getIdentity(), (request.getPageNumber() - 1) * request.getPageSize(), request.getPageSize());
    }

    public int queryZhuanwuLeaderRegistrationTotalCount(PageQueryZhuanwuLeaderRegistrationRequest request) {
        return zhuanwuLeaderRegistrationMapper.queryTotalCount(request.getSearchKey(), request.getName(), request.getPosition(), request.getPoliticalStatus(), request.getEducationLevel(), request.getPhone(),
                request.getIdentity());
    }


    public List<MinbingLeaderRegistration> pageQueryMinbingLeaderRegistration(PageQueryMinBingLeaderRegistrationRequest request) {
        return minbingLeaderRegistrationMapper.pageQuery(request.getSearchKey(), request.getName(), request.getPosition(), request.getPoliticalStatus(), request.getEducationLevel(), request.getPhone(),
                request.getIdentity(), (request.getPageNumber() - 1) * request.getPageSize(), request.getPageSize());
    }

    public int queryMinbingLeaderRegistrationTotalCount(PageQueryMinBingLeaderRegistrationRequest request) {
        return minbingLeaderRegistrationMapper.queryTotalCount(request.getSearchKey(), request.getName(), request.getPosition(), request.getPoliticalStatus(), request.getEducationLevel(), request.getPhone(),
                request.getIdentity());
    }

    /**
     * ???????????????
     */
    // ????????????????????????????????????????????????????????????????????????
    public List<PreBuildPartyOrganization> getPreBuildPartyOrganization(String partyOrganizationName,String identity){
        return preBuildPartyOrganizationMapper.findPartyNameAndApprovalByAndTeamAndIdentity(partyOrganizationName,identity);
    }
    //???????????????????????????
    public void addPreBuildPartyOrganization(AddPreBuildPartyOrganizationRequest request){
        PreBuildPartyOrganization preBuildPartyOrganization = new PreBuildPartyOrganization();
        BeanUtils.copyProperties(request,preBuildPartyOrganization);
        preBuildPartyOrganizationMapper.insert(preBuildPartyOrganization);
    }
    /**
     * ???????????????????????????
     */
    public List<BaseArmedInstitutionRegistration> getBaseArmedInstitutionRegistration(String name,String type,String identity){
        return baseArmedInstitutionRegistrationMapper.findNameAndTypeAndPlaceAndIdentity(name, type, identity);

    }
    public void addBaseArmedInstitutionRegistration(AddBaseArmedInstitutionRegistrationRequest request){
        BaseArmedInstitutionRegistration baseArmedInstitutionRegistration = new BaseArmedInstitutionRegistration();
        BeanUtils.copyProperties(request,baseArmedInstitutionRegistration);
        baseArmedInstitutionRegistrationMapper.insert(baseArmedInstitutionRegistration);
    }
    /**
     * ?????????????????????
     */
    public List<ZhuanwuLeaderRegistration> getZhuanwuLeaderRegistration(String idNumber,String identity){
        return zhuanwuLeaderRegistrationMapper.findWorkAndNameAndIdNumberAndPhoneAndIdentity( idNumber, identity);
    }
    public void addZhuanwuLeaderRegistration(AddZhuanwuLeaderRegistrationRequest request){
        ZhuanwuLeaderRegistration zhuanwuLeaderRegistration = new ZhuanwuLeaderRegistration();
        BeanUtils.copyProperties(request,zhuanwuLeaderRegistration);
        zhuanwuLeaderRegistrationMapper.insert(zhuanwuLeaderRegistration);
    }
    /**
     * ?????????????????????
     */
    public List<MinbingLeaderRegistration> getMinbingLeaderRegistration(String work,String position,String name,String politicalStatus,String phone,String teamNameAndPosition,String identity){
        return minbingLeaderRegistrationMapper.findWorkAndPositionAndNameAndPoliticalStatus(work, position, name, politicalStatus, phone, teamNameAndPosition, identity);
    }
    public void addMinbingLeaderRegistration(AddMinbingLeaderRegistrationRequest request){
        MinbingLeaderRegistration minbingLeaderRegistration = new MinbingLeaderRegistration();
        BeanUtils.copyProperties(request,minbingLeaderRegistration);
        minbingLeaderRegistrationMapper.insert(minbingLeaderRegistration);
    }
}