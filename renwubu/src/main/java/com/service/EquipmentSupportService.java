package com.service;


import com.model.request.PageQueryArmsEquipmentRegistrationRequest;
import com.model.request.PageQueryEmergencyEquipmentRegistrationRequest;
import com.model.request.PageQueryMilitaryCivilizationEquipmentRequest;
import com.persistence.entity.ArmsEquipmentRegistration;
import com.persistence.entity.EmergencyEquipmentRegistration;
import com.persistence.entity.MilitaryAndCivilianEquipmentRegistration;
import com.persistence.mapper.ArmsEquipmentRegistrationMapper;
import com.persistence.mapper.EmergencyEquipmentRegistrationMapper;
import com.persistence.mapper.MilitaryCivilizationEquipmentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuyuxiao
 */
@Service
public class EquipmentSupportService {
    @Resource
    private ArmsEquipmentRegistrationMapper armsEquipmentRegistrationMapper;

    @Resource
    private EmergencyEquipmentRegistrationMapper emergencyEquipmentRegistrationMapper;

    @Resource
    private MilitaryCivilizationEquipmentMapper militaryCivilizationEquipmentMapper;

    public List<ArmsEquipmentRegistration> pageQuery(PageQueryArmsEquipmentRegistrationRequest request) {
        return armsEquipmentRegistrationMapper.pageQuery(request.getSearchKey(), request.getEquipmentName(), request.getIdentity(),
                (request.getPageNumber() - 1) * request.getPageSize(), request.getPageSize());
    }


    public int queryTotalCount(PageQueryArmsEquipmentRegistrationRequest request) {
        return armsEquipmentRegistrationMapper.queryTotalCount(request.getSearchKey(), request.getEquipmentName(), request.getIdentity());
    }

    public List<EmergencyEquipmentRegistration> pageQuery(PageQueryEmergencyEquipmentRegistrationRequest request) {
        return emergencyEquipmentRegistrationMapper.pageQuery(request.getSearchKey(), request.getEquipmentPerformance(), request.getIdentity(),
                (request.getPageNumber() - 1) * request.getPageSize(), request.getPageSize());
    }


    public int queryTotalCount(PageQueryEmergencyEquipmentRegistrationRequest request) {
        return emergencyEquipmentRegistrationMapper.queryTotalCount(request.getSearchKey(), request.getEquipmentPerformance(), request.getIdentity());
    }

    public List<MilitaryAndCivilianEquipmentRegistration> pageQuery(PageQueryMilitaryCivilizationEquipmentRequest request) {
        return militaryCivilizationEquipmentMapper.pageQuery(request.getSearchKey(), request.getOrganizationType(), request.getIdentity(),
                (request.getPageNumber() - 1) * request.getPageSize(), request.getPageSize());
    }


    public int queryTotalCount(PageQueryMilitaryCivilizationEquipmentRequest request) {
        return militaryCivilizationEquipmentMapper.queryTotalCount(request.getSearchKey(), request.getOrganizationType(), request.getIdentity());
    }
}