package com.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.persistence.entity.BaseArmedInstitutionRegistration;
import com.persistence.entity.PreBuildPartyOrganization;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author wuyuxiao
 */
@Mapper
public interface BaseArmedInstitutionRegistrationMapper extends BaseMapper<BaseArmedInstitutionRegistration> {


    int queryTotalCount(@Param("searchKey") String searchKey,
                        @Param("name") String name,
                        @Param("type") String type,
                        @Param("place") String place,
                        @Param("approvalBy") String approvalBy,
                        @Param("level") String level,
                        @Param("managementRelation") String managementRelation,
                        @Param("regionDistribution") String regionDistribution,
                        @Param("identity") String identity);


    List<BaseArmedInstitutionRegistration> pageQuery(@Param("searchKey") String searchKey,
                                              @Param("name") String name,
                                              @Param("type") String type,
                                              @Param("place") String place,
                                              @Param("approvalBy") String approvalBy,
                                              @Param("level") String level,
                                              @Param("managementRelation") String managementRelation,
                                              @Param("regionDistribution") String regionDistribution,
                                              @Param("identity") String identity,
                                              @Param("offset") int offset, @Param("pageSize") int pageSize);


    int updateDeleteStatus(String id);

}