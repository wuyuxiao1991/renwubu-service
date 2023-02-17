package com.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.persistence.entity.TrainingMissionDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author wuyuxiao
 */
@Mapper
public interface TrainingMissionMapper extends BaseMapper<TrainingMissionDetails> {


    List<TrainingMissionDetails> pageQuery(@Param("year") String year,
                                           @Param("province") String province,
                                           @Param("city") String city,
                                           @Param("district") String district,
                                           @Param("identity") String identity,
                                           @Param("offset") int offset, @Param("pageSize") int pageSize);

    int queryTotalCount(@Param("year") String year,
                        @Param("province") String province,
                        @Param("city") String city,
                        @Param("district") String district,
                        @Param("identity") String identity);

    int updateDeleteStatus(String id);

}