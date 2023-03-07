package com.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.persistence.entity.MilitaryStrengthGuarantee;
import com.persistence.entity.MilitaryStrengthPlan;
import com.persistence.entity.MilitaryStrengthRegistration;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author wuyuxiao
 */
@Mapper
public interface MilitaryStrengthRegistrationMapper extends BaseMapper<MilitaryStrengthRegistration> {


    List<MilitaryStrengthRegistration> pageQuery(@Param("searchKey") String searchKey,
                                                 @Param("requiredBy") String requiredBy,
                                                 @Param("taskType") String taskType,
                                                 @Param("concreteTask") String concreteTask,
                                                 @Param("identity") String identity,
                                                 @Param("offset") int offset, @Param("pageSize") int pageSize);

    int queryTotalCount(@Param("searchKey") String searchKey,
                        @Param("requiredBy") String requiredBy,
                        @Param("taskType") String taskType,
                        @Param("concreteTask") String concreteTask,
                        @Param("identity") String identity);

    int updateDeleteStatus(String id);

    List<MilitaryStrengthRegistration> findRequiredByAndTaskTypeAndConcreteTask(@Param("requiredBy")String requiredBy,
                                                                                @Param("taskType")String taskType,
                                                                                @Param("concreteTask")String concreteTask,
                                                                                @Param("identity")String identity);


}