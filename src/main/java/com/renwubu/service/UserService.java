package com.renwubu.service;

import com.renwubu.persistence.entity.UserInfo;
import com.renwubu.persistence.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wuyuxiao
 */
@Service
public class UserService{
    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo getUserInfoByName(String name){
        return  userInfoMapper.findByName(name);
    }
}
