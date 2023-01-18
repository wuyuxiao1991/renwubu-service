package com.persistence.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.persistence.entity.UserInfo;

/**
 * @author wuyuxiao
 */
@Mapper
public
interface UserInfoMapper extends BaseMapper<UserInfo> {

    UserInfo findByName(String name);

}