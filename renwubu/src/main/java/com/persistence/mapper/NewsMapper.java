package com.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.persistence.entity.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author wuyuxiao
 */
@Mapper
public interface NewsMapper extends BaseMapper<News> {

    List<News> findBySubmenuGuid(String submenuGuid);

    News findByGuid(String newsGuid);


    List<News> findBySubmenuGuidAndTitle(@Param("submenuGuid") String submenuGuid, @Param("title") String title);


    List<News> pageQueryNews(@Param("submenuGuids") List<String> submenuGuids,
                             @Param("searchKey") String searchKey,
                             @Param("offset") int offset, @Param("pageSize") int pageSize);

    int queryNewsTotalCount(@Param("submenuGuids") List<String> submenuGuids,
                             @Param("searchKey") String searchKey);

    int updateDeleteStatus(String newsGuid);

}