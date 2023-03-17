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


    public List<PeoplePotentialRegistration> getPeoplePotentialRegistration(AddPeoplePotentialRegistrationRequest request){
        return peoplePotentialMapper.findByNameAndIdNumber(request.getName(), request.getIdNumber(), request.getIdentity());
    }

    public List<CompanyPotentialRegistration> getCompanyPotentialRegistration(AddCompanyPotentialRegistrationRequest request){
        return companyPotentialMapper.findByName(request.getName(), request.identity);
    }

    public List<EquipmentPotentialRegistration> getEquipmentPotentialRegistration(AddEquipmentPotentialRegistrationRequest request){
        return equipmentPotentialMapper.findByNameAndStoragePlace(request.getName(),request.getStoragePlace(), request.identity);
    }

    public void addPeoplePotentialRegistration(AddPeoplePotentialRegistrationRequest request){
        PeoplePotentialRegistration peoplePotentialRegistration = new PeoplePotentialRegistration();
        BeanUtils.copyProperties(request,peoplePotentialRegistration);
        peoplePotentialMapper.insert(peoplePotentialRegistration);
    }

    public void addCompanyPotentialRegistration(AddCompanyPotentialRegistrationRequest request){
        CompanyPotentialRegistration companyPotentialRegistration = new CompanyPotentialRegistration();
        BeanUtils.copyProperties(request,companyPotentialRegistration);
        companyPotentialMapper.insert(companyPotentialRegistration);
    }

    public void addEquipmentPotentialRegistration(AddEquipmentPotentialRegistrationRequest request){
        EquipmentPotentialRegistration equipmentPotentialRegistration = new EquipmentPotentialRegistration();
        BeanUtils.copyProperties(request,equipmentPotentialRegistration);
        equipmentPotentialMapper.insert(equipmentPotentialRegistration);
    }

}