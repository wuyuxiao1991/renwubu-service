package com.service;


import com.model.request.DeleteItemRequest;
import com.persistence.mapper.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wuyuxiao
 */
@Service
public class CommonService {
    @Autowired
    private CommonMapper commonMapper;

    public void deleteItem(DeleteItemRequest request) {
        commonMapper.updateDeleteStatus(request.getId(), request.getTableName());
    }

}