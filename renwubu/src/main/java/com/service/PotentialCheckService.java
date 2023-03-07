package com.service;


import com.model.request.*;
import com.persistence.entity.*;
import com.persistence.mapper.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuyuxiao
 */
@Service
public class PotentialCheckService {
    @Resource
    private PeoplePotentialMapper peoplePotentialMapper;
    @Resource
    private CompanyPotentialMapper companyPotentialMapper;
    @Resource
    private EquipmentPotentialMapper equipmentPotentialMapper;

    public List<PeoplePotentialRegistration> pageQueryPeoplePotential(PageQueryPeoplePotentialRequest request) {
        return peoplePotentialMapper.pageQuery(request.getSearchKey(), request.getIdentity(),
                (request.getPageNumber() - 1) * request.getPageSize(), request.getPageSize());
    }


    public int queryPeoplePotentialTotalCount(PageQueryPeoplePotentialRequest request) {
        return peoplePotentialMapper.queryTotalCount(request.getSearchKey(), request.getIdentity());
    }


    public List<CompanyPotentialRegistration> pageQueryCompanyPotential(PageQueryCompanyPotentialRequest request) {
        return companyPotentialMapper.pageQuery(request.getSearchKey(), request.getIdentity(),
                (request.getPageNumber() - 1) * request.getPageSize(), request.getPageSize());
    }


    public int queryCompanyPotentialTotalCount(PageQueryCompanyPotentialRequest request) {
        return companyPotentialMapper.queryTotalCount(request.getSearchKey(), request.getIdentity());
    }

    public List<EquipmentPotentialRegistration> pageQueryEquipmentPotential(PageQueryEquipmentPotentialRequest request) {
        return equipmentPotentialMapper.pageQuery(request.getSearchKey(), request.getIdentity(),
                (request.getPageNumber() - 1) * request.getPageSize(), request.getPageSize());
    }


    public int queryEquipmentPotentialTotalCount(PageQueryEquipmentPotentialRequest request) {
        return equipmentPotentialMapper.queryTotalCount(request.getSearchKey(), request.getIdentity());
    }


}