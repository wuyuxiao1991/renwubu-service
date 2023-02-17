package com.endpoint;


import com.model.BaseResponse;
import com.model.dto.NewsDto;
import com.model.request.*;
import com.persistence.entity.Menu;
import com.persistence.entity.Submenu;
import com.persistence.entity.TeamDetail;
import com.service.OrganizationBuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 组织建设
 *
 * @author wuyuxiao
 */
@RestController
@RequestMapping("/api")
public class OrganizationBuildController {
    @Autowired
    private OrganizationBuildService organizationBuildService;

    /**
     * 新增一条
     *
     * @param request
     * @return
     */
    @PostMapping("/add_team_detail")
    public BaseResponse<Boolean> addTeamDetail(@RequestBody AddTeamDetailRequest request) {
        try {
            //1.判重
            List<TeamDetail> teamDetails = organizationBuildService.getTeamDetail(request.getName(), request.getIdentity());
            if (!teamDetails.isEmpty()) {
                return BaseResponse.failed("不能添加重复数据！");
            }

            //2.新增
            organizationBuildService.addTeamDetail(request);

            return BaseResponse.ok();
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

    /**
     * 删除
     * @param request
     * @return
     */
    @PostMapping("/delete_team_detail")
    public BaseResponse<Boolean> deleteTeamDetail(@RequestBody DeleteTeamDetailRequest request) {
        try {
            organizationBuildService.deleteTeamDetail(request);
            return BaseResponse.ok(true);
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }
}
