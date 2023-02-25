package com.endpoint;


import com.model.BaseResponse;
import com.model.dto.NewsDto;
import com.model.request.*;
import com.persistence.entity.*;
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
     * 队伍详情登记表分页接口
     *
     * @param request
     * @return
     */
    @PostMapping("/page_query_team_detail")
    public BaseResponse<BasePageQueryResponse<TeamDetail>> pageQueryTeamDetail(@RequestBody PageQueryTeamDetailRequest request) {
        try {

            //1.分页查询
            List<TeamDetail> list = organizationBuildService.pageQueryTeamDetail(request);

            //2.查询总记录数
            int count = organizationBuildService.queryTeamDetailTotalCount(request);

            return BaseResponse.ok(new BasePageQueryResponse<>(list, count));
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

    /**
     * 人员详情表分页接口
     *
     * @param request
     * @return
     */
    @PostMapping("/page_query_people_detail")
    public BaseResponse<BasePageQueryResponse<PeopleDetail>> pageQueryTeamDetail(@RequestBody PageQueryPeopleDetailRequest request) {
        try {

            //1.分页查询
            List<PeopleDetail> list = organizationBuildService.pageQueryPeopleDetail(request);

            //2.查询总记录数
            int count = organizationBuildService.queryPeopleDetailTotalCount(request);

            return BaseResponse.ok(new BasePageQueryResponse<>(list, count));
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }


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
     * 新增一条添加人员详细表的方法
     * @param request
     * @return
     */
    @PostMapping("/add_people_detail")
    public BaseResponse<Boolean> addPeopleDetail(@RequestBody AddPeopleDetailRequest request){
        try {


        // 判重
        List<PeopleDetail> peopleDetails=organizationBuildService.getPeopleDetail(request.getIdNumber(), request.getIdentity());
        if (!peopleDetails.isEmpty()) {
            return BaseResponse.failed("不能添加重复数据！");
        }
        // 新增
        organizationBuildService.addPeopleDetail(request);
        return BaseResponse.ok();
        }catch (Exception e){
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
