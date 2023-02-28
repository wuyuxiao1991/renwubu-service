package com.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.persistence.entity.SecondMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wuyuxiao
 */
@Mapper
public interface SecondMenuMapper extends BaseMapper<SecondMenu> {

    List<SecondMenu> findByMenuGuid(String menuGuid);

    List<SecondMenu> findByName(String menuGuid);

    SecondMenu findByGuid(String secondMenuGuid);

}