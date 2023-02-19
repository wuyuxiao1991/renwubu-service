package com.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.persistence.entity.MilitaryStrengthPlan;
import com.persistence.entity.TrainingMissionDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author wuyuxiao
 */
@Mapper
public interface MilitaryStrengthPlanMapper extends BaseMapper<MilitaryStrengthPlan> {


    List<MilitaryStrengthPlan> pageQuery(@Param("searchKey") String searchKey,
                                           @Param("planName") String planName,
                                           @Param("identity") String identity,
                                           @Param("offset") int offset, @Param("pageSize") int pageSize);

    int queryTotalCount(@Param("searchKey") String searchKey,
                        @Param("planName") String planName,
                        @Param("identity") String identity);

    int updateDeleteStatus(String id);

}