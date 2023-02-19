package com.service;


import com.model.request.PageQueryMilitaryServiceRegistrationRequest;
import com.persistence.entity.MilitaryServiceRegistration;
import com.persistence.mapper.MilitaryServiceRegistrationMapper;
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

}