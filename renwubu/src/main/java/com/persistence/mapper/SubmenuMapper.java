package com.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.persistence.entity.Submenu;

import java.util.List;

/**
 * @author wuyuxiao
 */
@Mapper
public interface SubmenuMapper extends BaseMapper<Submenu> {

    List<Submenu> findByMenuGuid(String menuGuid);

    List<Submenu> findByName(String menuGuid);

    Submenu findByGuid(String submenuGuid);

}