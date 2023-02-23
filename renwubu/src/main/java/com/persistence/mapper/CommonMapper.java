package com.persistence.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author wuyuxiao
 */
@Mapper
public interface CommonMapper {

    int updateDeleteStatus(@Param("id") String id, @Param("tableName") String tableName);

}