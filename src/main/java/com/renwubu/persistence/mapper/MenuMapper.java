package com.renwubu.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import  com.renwubu.persistence.entity.Menu;

import java.util.List;


/**
 * @author wuyuxiao
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> findByNameAndIdentity(String name, String identity);

}