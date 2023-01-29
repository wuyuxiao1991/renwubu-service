package com.endpoint;


import com.model.BaseResponse;
import com.model.dto.SubmenuDto;
import com.model.dto.SubmenuNews;
import com.model.request.AddMenuRequest;
import com.model.request.GetMenuRequest;
import com.model.request.GetSubmenuListRequest;
import com.persistence.entity.Menu;
import com.persistence.entity.Submenu;
import com.service.MenuService;
import com.service.NewsService;
import com.service.SubmenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wuyuxiao
 */
@RestController
@RequestMapping("/api")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @Autowired
    private SubmenuService submenuService;

    @Autowired
    private NewsService newsService;


    @PostMapping("/get_menu")
    public BaseResponse<List<SubmenuNews>> getMenu(@RequestBody GetMenuRequest request) {
        try {
            //1.根据菜单名找到母菜单
            Menu menu = menuService.getMenus(request.getName(), request.getIdentity());

            //2.根据母菜单找到子菜单
            List<Submenu> submenuList = submenuService.getSubmenusByMenuGuid(menu.menuGuid);

            //3.找到子菜单下所有news
            List<SubmenuNews> data = submenuList.stream().map(p -> new SubmenuNews(p.submenuGuid, p.name, newsService.getNewsBySubmenuGuid(p.submenuGuid))).collect(Collectors.toList());
            return BaseResponse.ok(data);
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }


    @PostMapping("/add_submenu")
    public BaseResponse<SubmenuDto> addMenu(@RequestBody AddMenuRequest request) {
        try {
            //1.根据菜单名找到母菜单
            Menu menu = menuService.getMenus(request.getMenuName(), request.getIdentity());

            //2.判断是否已有同名子菜单
            List<Submenu> submenuList = submenuService.getSubmenusByMenuGuid(menu.menuGuid);
            boolean existSubmenu = submenuList.stream().map(p -> p.name).collect(Collectors.toList()).contains(request.getSubmenuName());
            if (existSubmenu) {
                return BaseResponse.failed("已有同名子菜单，不能重复添加！");
            }

            //3.新增子菜单
            Submenu submenu = submenuService.addSubmenu(menu.menuGuid, request.getSubmenuName());

            return BaseResponse.ok(SubmenuDto.transform(submenu));
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

    @PostMapping("/get_submenu_by_menu")
    public BaseResponse<List<SubmenuDto>> getSubmenuList(@RequestBody GetSubmenuListRequest request) {
        try {
            //1.根据菜单名找到母菜单
            Menu menu = menuService.getMenus(request.getMenuName(), request.getIdentity());

            //2.根据母菜单找到子菜单
            List<Submenu> submenuList = submenuService.getSubmenusByMenuGuid(menu.menuGuid);

            return BaseResponse.ok(submenuList.stream().map(SubmenuDto::transform).collect(Collectors.toList()));
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }
}
