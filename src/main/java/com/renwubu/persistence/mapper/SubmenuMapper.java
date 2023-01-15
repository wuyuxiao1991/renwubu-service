package com.renwubu.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.renwubu.persistence.entity.Submenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wuyuxiao
 */
@Mapper
public interface SubmenuMapper extends BaseMapper<Submenu> {

    List<Submenu> findByNameAndIdentity(String menuGuid);


}