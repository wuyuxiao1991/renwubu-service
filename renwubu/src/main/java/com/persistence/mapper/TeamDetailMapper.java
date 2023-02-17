package com.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.persistence.entity.TeamDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author wuyuxiao
 */
@Mapper
public interface TeamDetailMapper extends BaseMapper<TeamDetail> {


    List<TeamDetail> findByNameAndIdentity(@Param("name") String name, @Param("identity") String identity);

    int updateDeleteStatus(String id);

}