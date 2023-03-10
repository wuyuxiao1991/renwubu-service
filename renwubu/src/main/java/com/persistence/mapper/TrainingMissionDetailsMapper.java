package com.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.persistence.entity.TrainingMissionDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;


/**
 * @author wuyuxiao
 */
@Mapper
public interface TrainingMissionDetailsMapper extends BaseMapper<TrainingMissionDetails> {


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

    List<HashMap<String, String>> groupByPlace(@Param("identity") String identity);

    List<HashMap<String, String>> groupByTotalDayCount(@Param("identity") String identity);

    List<TrainingMissionDetails> findByTeamTypeAndTeamBranchNameAndIdentity(@Param("teamType") String teamType,@Param("teamBranchName") String teamBranchName,@Param("identity") String identity);

}