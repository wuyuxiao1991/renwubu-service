package com.service;


import com.model.request.PageQueryBaseArmedInstitutionRegistrationRequest;
import com.model.request.PageQueryMinBingLeaderRegistrationRequest;
import com.model.request.PageQueryPreBuildPartyOrganizationRequest;
import com.model.request.PageQueryZhuanwuLeaderRegistrationRequest;
import com.persistence.entity.BaseArmedInstitutionRegistration;
import com.persistence.entity.MinbingLeaderRegistration;
import com.persistence.entity.PreBuildPartyOrganization;
import com.persistence.entity.ZhuanwuLeaderRegistration;
import com.persistence.mapper.BaseArmedInstitutionRegistrationMapper;
import com.persistence.mapper.MinbingLeaderRegistrationMapper;
import com.persistence.mapper.PreBuildPartyOrganizationMapper;
import com.persistence.mapper.ZhuanwuLeaderRegistrationMapper;
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

}