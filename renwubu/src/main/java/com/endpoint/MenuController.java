package com.endpoint;


import com.alibaba.fastjson.JSON;
import com.model.BaseResponse;
import com.model.dto.NewsDto;
import com.model.dto.SubmenuNews;
import com.model.request.GetMenuRequest;
import com.persistence.entity.Menu;
import com.persistence.entity.News;
import com.persistence.entity.Submenu;
import com.service.MenuService;
import com.service.NewsService;
import com.service.SubmenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/get_menu")
    public BaseResponse<List<SubmenuNews>> getMenu(@RequestBody GetMenuRequest request) {
        try {
            //1.根据菜单名找到母菜单
            Menu menu = menuService.getMenus(request.getName(), request.getIdentity());

            //2.根据母菜单找到子菜单
            List<Submenu> submenuList = submenuService.getSubmenus(menu.menuGuid);

            //3.找到子菜单下所有news
            List<SubmenuNews> data = submenuList.stream().map(p -> new SubmenuNews(p.submenuGuid, p.name, transform(p))).collect(Collectors.toList());
            return BaseResponse.ok(data);
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

    private List<NewsDto> transform(Submenu subMenu) {
        List<News> newsList = newsService.getNews(subMenu.submenuGuid);
        return newsList.stream().map(p -> new NewsDto(p.newsGuid, p.title, p.text, JSON.parseObject(p.images, List.class))).collect(Collectors.toList());
    }
}
