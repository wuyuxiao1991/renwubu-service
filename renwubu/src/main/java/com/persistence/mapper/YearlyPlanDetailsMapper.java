package com.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.persistence.entity.PeopleDetail;
import com.persistence.entity.TrainingMissionDetails;
import com.persistence.entity.YearlyPlanDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author wuyuxiao
 */
@Mapper
public interface YearlyPlanDetailsMapper extends BaseMapper<YearlyPlanDetails> {


    List<YearlyPlanDetails> pageQuery(@Param("searchKey") String searchKey,
                                           @Param("year") String year,
                                           @Param("month") String month,
                                           @Param("identity") String identity,
                                           @Param("offset") int offset, @Param("pageSize") int pageSize);

    int queryTotalCount(@Param("searchKey") String searchKey,
                        @Param("year") String year,
                        @Param("month") String month,
                        @Param("identity") String identity);

    int updateDeleteStatus(String id);
    List<YearlyPlanDetails> findYearMonthAndTeamBranch(@Param("year") String year,@Param("month") String month,@Param("teamBranch") String teamBranch,@Param("identity") String identity);

}