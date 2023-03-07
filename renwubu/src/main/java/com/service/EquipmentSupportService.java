package com.service;


import com.model.request.*;
import com.persistence.entity.ArmsEquipmentRegistration;
import com.persistence.entity.EmergencyEquipmentRegistration;
import com.persistence.entity.MilitaryAndCivilianEquipmentRegistration;
import com.persistence.mapper.ArmsEquipmentRegistrationMapper;
import com.persistence.mapper.EmergencyEquipmentRegistrationMapper;
import com.persistence.mapper.MilitaryCivilizationEquipmentMapper;
import org.springframework.beans.BeanUtils;
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

    /**
     * 武器装备登记表
     */
    public List<ArmsEquipmentRegistration> getArmsEquipmentRegistration(String equipmentName,String type,String identity){
        return armsEquipmentRegistrationMapper.findEquipmentNameAndType(equipmentName, type, identity);

    }
    public void addArmsEquipmentRegistration(AddArmsEquipmentRegistrationRequest request){
        ArmsEquipmentRegistration armsEquipmentRegistration = new ArmsEquipmentRegistration();
        BeanUtils.copyProperties(request,armsEquipmentRegistration);
        armsEquipmentRegistrationMapper.insert(armsEquipmentRegistration);
    }
    /**
     * 应急专用装备登记表
     */
    public List<EmergencyEquipmentRegistration> getEmergencyEquipmentRegistration(String equipmentName,String type,String identity){
        return emergencyEquipmentRegistrationMapper.findEquipmentNameAndType(equipmentName, type, identity);
    }
    public void AddEmergencyEquipmentRegistration(AddEmergencyEquipmentRegistrationRequest request){
        EmergencyEquipmentRegistration emergencyEquipmentRegistration = new EmergencyEquipmentRegistration();
        BeanUtils.copyProperties(request,emergencyEquipmentRegistration);
        emergencyEquipmentRegistrationMapper.insert(emergencyEquipmentRegistration);


    }

    /**
     * 军民通用装备表
     * @param equipmentName
     * @param type
     * @param identity
     * @return
     */
    public List<MilitaryAndCivilianEquipmentRegistration>getMilitaryAndCivilianEquipmentRegistration(String equipmentName,String type,String identity){
        return militaryCivilizationEquipmentMapper.findMilitaryEquipmentNameAndType(equipmentName, type, identity);

    }
    public void addMilitaryAndCivilianEquipmentRegistration(AddMilitaryAndCivilianEquipmentRegistrationRequest request){
        MilitaryAndCivilianEquipmentRegistration militaryAndCivilianEquipmentRegistration = new MilitaryAndCivilianEquipmentRegistration();
        BeanUtils.copyProperties(request,militaryAndCivilianEquipmentRegistration);
        militaryCivilizationEquipmentMapper.insert(militaryAndCivilianEquipmentRegistration);
    }


    public int queryTotalCount(PageQueryMilitaryCivilizationEquipmentRequest request) {
        return militaryCivilizationEquipmentMapper.queryTotalCount(request.getSearchKey(), request.getOrganizationType(), request.getIdentity());
    }
}