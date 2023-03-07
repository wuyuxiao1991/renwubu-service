package com.service;


import com.model.request.*;
import com.persistence.entity.PeopleDetail;
import com.persistence.entity.TeamDetail;
import com.persistence.mapper.PeopleDetailMapper;
import com.persistence.mapper.TeamDetailMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wuyuxiao
 */
@Service
public class OrganizationBuildService {
    @Resource
    private TeamDetailMapper teamDetailMapper;
    @Resource
    private PeopleDetailMapper peopleDetailMapper;

    public List<TeamDetail> pageQueryTeamDetail(PageQueryTeamDetailRequest request) {
        return teamDetailMapper.pageQuery(request.getSearchKey(), request.getIdentity(),
                (request.getPageNumber() - 1) * request.getPageSize(), request.getPageSize());
    }


    public int queryTeamDetailTotalCount(PageQueryTeamDetailRequest request) {
        return teamDetailMapper.queryTotalCount(request.getSearchKey(), request.getIdentity());
    }

    public List<PeopleDetail> pageQueryPeopleDetail(PageQueryPeopleDetailRequest request) {
        return peopleDetailMapper.pageQuery(request.getSearchKey(), request.getName(), request.getIdCard(), request.getPhone(), request.getIdentity(),
                (request.getPageNumber() - 1) * request.getPageSize(), request.getPageSize());
    }


    public int queryPeopleDetailTotalCount(PageQueryPeopleDetailRequest request) {
        return peopleDetailMapper.queryTotalCount(request.getSearchKey(), request.getName(), request.getIdCard(), request.getPhone(), request.getIdentity());
    }

    public List<TeamDetail> getTeamDetail(String name, String identity) {
        return teamDetailMapper.findByNameAndIdentity(name, identity);
    }


    public void addTeamDetail(AddTeamDetailRequest request) {
        TeamDetail teamDetail = new TeamDetail();
        BeanUtils.copyProperties(request, teamDetail);
        teamDetailMapper.insert(teamDetail);
    }


    public void deleteTeamDetail(DeleteTeamDetailRequest request) {
        teamDetailMapper.updateDeleteStatus(request.getId());
    }

    /**/
    public List<PeopleDetail> getPeopleDetail(String idNumber,String identity){
        return peopleDetailMapper.findByIdCardAndIdentity(idNumber, identity);
    }

    public void addPeopleDetail(AddPeopleDetailRequest request){
        PeopleDetail peopleDetail=new PeopleDetail();
        BeanUtils.copyProperties(request,peopleDetail);
        peopleDetailMapper.insert(peopleDetail);
    }

}