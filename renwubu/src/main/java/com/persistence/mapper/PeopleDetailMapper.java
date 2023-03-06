package com.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.persistence.entity.PeopleDetail;
import com.persistence.entity.TeamDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;


/**
 * @author wuyuxiao
 */
@Mapper
public interface PeopleDetailMapper extends BaseMapper<PeopleDetail> {


    List<PeopleDetail> pageQuery(@Param("searchKey") String searchKey,
                               @Param("name") String name,
                               @Param("idCard") String idCard,
                               @Param("phone") String phone,
                               @Param("identity") String identity,
                               @Param("offset") int offset, @Param("pageSize") int pageSize);

    int queryTotalCount(@Param("searchKey") String searchKey,
                        @Param("name") String name,
                        @Param("idCard") String idCard,
                        @Param("phone") String phone,
                        @Param("identity") String identity);

    int updateDeleteStatus(String id);

    List<HashMap<String,String>> groupBy(@Param("groupByField") String groupByField, @Param("identity") String identity);

}