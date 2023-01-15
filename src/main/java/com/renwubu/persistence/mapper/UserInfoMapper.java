package com.renwubu.persistence.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.renwubu.persistence.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wuyuxiao
 */
@Mapper
public
interface UserInfoMapper extends BaseMapper<UserInfo> {

    UserInfo findByName(String name);

}