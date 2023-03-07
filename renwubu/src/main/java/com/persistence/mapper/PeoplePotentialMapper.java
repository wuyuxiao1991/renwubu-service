package com.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.persistence.entity.PeoplePotentialRegistration;
import com.persistence.entity.TeamDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;


/**
 * @author wuyuxiao
 */
@Mapper
public interface PeoplePotentialMapper extends BaseMapper<PeoplePotentialRegistration> {


    List<PeoplePotentialRegistration> pageQuery(@Param("searchKey") String searchKey,
                                                @Param("identity") String identity,
                                                @Param("offset") int offset, @Param("pageSize") int pageSize);

    int queryTotalCount(@Param("searchKey") String searchKey,
                        @Param("identity") String identity);
}