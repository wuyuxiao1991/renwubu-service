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
public interface TrainingMissionDetailMapper extends BaseMapper<TrainingMissionDetails> {


    List<TrainingMissionDetails> pageQuery(@Param("searchKey") String searchKey,
                                           @Param("year") String year,
                                           @Param("province") String province,
                                           @Param("city") String city,
                                           @Param("district") String district,
                                           @Param("identity") String identity,
                                           @Param("offset") int offset, @Param("pageSize") int pageSize);

    int queryTotalCount(@Param("searchKey") String searchKey,
                        @Param("year") String year,
                        @Param("province") String province,
                        @Param("city") String city,
                        @Param("district") String district,
                        @Param("identity") String identity);

    int updateDeleteStatus(String id);

}