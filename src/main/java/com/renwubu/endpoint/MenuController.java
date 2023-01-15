package com.renwubu.endpoint;


import com.alibaba.fastjson.JSONObject;
import com.renwubu.model.BaseResponse;
import com.renwubu.model.dto.NewsContent;
import com.renwubu.model.dto.SubmenuNewsDto;
import com.renwubu.model.request.GetMenuRequest;
import com.renwubu.persistence.entity.Menu;
import com.renwubu.persistence.entity.Submenu;
import com.renwubu.service.MenuService;
import com.renwubu.service.SubmenuService;
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

    @PostMapping("/get_menu")
    public BaseResponse<List<SubmenuNewsDto>> getMenu(@RequestBody GetMenuRequest request) {
        try {
            Menu menu = menuService.getMenus(request.getName(), request.getIdentity());
            List<Submenu> submenuList = submenuService.getSubmenus(menu.menuGuid);
            List<SubmenuNewsDto> data = submenuList.stream().map(this::transform).collect(Collectors.toList());
            return BaseResponse.ok(data);
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

    private SubmenuNewsDto transform(Submenu subMenu) {
        NewsContent newsContent = JSONObject.parseObject(subMenu.content, NewsContent.class);
        return new SubmenuNewsDto(subMenu.name, newsContent);
    }
}
