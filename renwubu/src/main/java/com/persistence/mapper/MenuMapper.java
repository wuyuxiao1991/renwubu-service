package com.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.persistence.entity.Menu;

import java.util.List;


/**
 * @author wuyuxiao
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> findByNameAndIdentity(@Param("name") String name, @Param("identity") String identity);

}