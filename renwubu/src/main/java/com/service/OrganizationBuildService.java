package com.service;


import com.model.request.AddTeamDetailRequest;
import com.model.request.DeleteTeamDetailRequest;
import com.persistence.entity.TeamDetail;
import com.persistence.mapper.TeamDetailMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuyuxiao
 */
@Service
public class OrganizationBuildService {
    @Resource
    private TeamDetailMapper teamDetailMapper;

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
}