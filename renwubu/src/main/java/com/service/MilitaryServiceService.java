package com.service;


import com.model.request.AddMilitaryServiceRegistrationRequest;
import com.model.request.PageQueryMilitaryServiceRegistrationRequest;
import com.persistence.entity.MilitaryServiceRegistration;
import com.persistence.mapper.MilitaryServiceRegistrationMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuyuxiao
 */
@Service
public class MilitaryServiceService {
    @Resource
    private MilitaryServiceRegistrationMapper militaryServiceRegistrationMapper;

    public List<MilitaryServiceRegistration> pageQuery(PageQueryMilitaryServiceRegistrationRequest request) {
        return militaryServiceRegistrationMapper.pageQuery(request.getSearchKey(), request.getName(), request.getIdCard(), request.getIdentity(),
                (request.getPageNumber() - 1) * request.getPageSize(), request.getPageSize());
    }


    public int queryTotalCount(PageQueryMilitaryServiceRegistrationRequest request) {
        return militaryServiceRegistrationMapper.queryTotalCount(request.getSearchKey(), request.getName(), request.getIdCard(), request.getIdentity());
    }

    public List<MilitaryServiceRegistration>getMilitaryServiceRegistration(String idNumber,String identity){
        return militaryServiceRegistrationMapper.findIdNumber(idNumber,identity);
    }
    public void addMilitaryServiceRegistration(AddMilitaryServiceRegistrationRequest request){
        MilitaryServiceRegistration militaryServiceRegistration = new MilitaryServiceRegistration();
        BeanUtils.copyProperties(request,militaryServiceRegistration);
        militaryServiceRegistrationMapper.insert(militaryServiceRegistration);
    }
}