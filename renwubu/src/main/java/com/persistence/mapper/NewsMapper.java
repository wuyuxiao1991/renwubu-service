package com.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.persistence.entity.News;

import java.util.List;


/**
 * @author wuyuxiao
 */
@Mapper
public interface NewsMapper extends BaseMapper<News> {

    List<News> findBySubmenuGuid(String submenuGuid);

}