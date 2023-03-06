package com.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.persistence.entity.TeamDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;


/**
 * @author wuyuxiao
 */
@Mapper
public interface TeamDetailMapper extends BaseMapper<TeamDetail> {


    List<TeamDetail> pageQuery(@Param("searchKey") String searchKey,
                               @Param("identity") String identity,
                               @Param("offset") int offset, @Param("pageSize") int pageSize);

    int queryTotalCount(@Param("searchKey") String searchKey,
                        @Param("identity") String identity);

    List<TeamDetail> findByNameAndIdentity(@Param("name") String name, @Param("identity") String identity);

    int updateDeleteStatus(String id);

    List<HashMap<String, String>> groupBy(@Param("groupByField") String groupByField, @Param("identity") String identity);

    List<HashMap<String, String>> groupByTeam(@Param("identity") String identity);

}