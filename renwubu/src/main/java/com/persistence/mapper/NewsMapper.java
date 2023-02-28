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

    List<News> findByThirdMenuGuid(String thirdMenuGuid);

    News findByGuid(String newsGuid);


    List<News> findBythirdMenuGuidAndTitle(@Param("thirdMenuGuid") String thirdMenuGuid, @Param("title") String title);


    List<News> pageQueryNews(@Param("thirdMenuGuid") String thirdMenuGuid,
                             @Param("searchKey") String searchKey,
                             @Param("offset") int offset, @Param("pageSize") int pageSize);

    int queryNewsTotalCount(@Param("thirdMenuGuid") String thirdMenuGuid,
                             @Param("searchKey") String searchKey);

    int updateDeleteStatus(String newsGuid);

}