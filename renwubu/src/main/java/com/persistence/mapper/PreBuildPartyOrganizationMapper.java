package com.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.persistence.entity.PreBuildPartyOrganization;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author wuyuxiao
 */
@Mapper
public interface PreBuildPartyOrganizationMapper extends BaseMapper<PreBuildPartyOrganization> {


    int queryTotalCount(@Param("searchKey") String searchKey,
                        @Param("partyOrganizationName") String partyOrganizationName,
                        @Param("identity") String identity);

    List<PreBuildPartyOrganization> pageQuery(@Param("searchKey") String searchKey,
                                              @Param("partyOrganizationName") String partyOrganizationName,
                                              @Param("identity") String identity,
                                              @Param("offset") int offset, @Param("pageSize") int pageSize);


    int updateDeleteStatus(String id);

    List<PreBuildPartyOrganization> findPartyNameAndApprovalByAndTeamAndIdentity
            (@Param("partyOrganizationName") String partyOrganizationName,@Param("identity")String identity);

}