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

    /**
     * @param guid
     * @return menu
     */
    Menu findByGuid(@Param("guid") String guid);

    /**
     * @param identity
     * @return menu
     */
    List<Menu> findByIdentituy(@Param("identity") String identity);
}