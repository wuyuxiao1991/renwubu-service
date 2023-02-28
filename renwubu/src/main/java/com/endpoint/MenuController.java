package com.endpoint;


import com.model.BaseResponse;
import com.model.dto.MenuDto;
import com.model.dto.SecondMenuDto;
import com.model.dto.ThirdMenuDto;
import com.model.request.AddSecondMenuRequest;
import com.model.request.AddThirdMenuRequest;
import com.model.request.GetMenuRequest;
import com.persistence.entity.Menu;
import com.persistence.entity.SecondMenu;
import com.persistence.entity.ThirdMenu;
import com.service.MenuService;
import com.service.NewsService;
import com.service.SecondMenuService;
import com.service.ThirdMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    private SecondMenuService secondMenuService;

    @Autowired
    private ThirdMenuService thirdMenuService;

    @Autowired
    private NewsService newsService;


    @PostMapping("/get_menu")
    public BaseResponse<List<MenuDto>> getMenu(@RequestBody GetMenuRequest request) {
        try {
            List<MenuDto> result = new ArrayList<>();
            //1.根据菜单名找到母菜单
            List<Menu> menus = menuService.getMenus(request.getIdentity());

            //2.根据母菜单找到子菜单
            for (Menu menu : menus
            ) {
                List<SecondMenuDto> secondMenuDtoList = new ArrayList<>();
                MenuDto menuDto = new MenuDto(menu.menuGuid, menu.name, secondMenuDtoList);
                result.add(menuDto);

                for (SecondMenu secondMenu : secondMenuService.getSecondMenusByMenuGuid(menu.menuGuid)
                ) {
                    SecondMenuDto secondMenuDto = new SecondMenuDto();
                    secondMenuDto.setSecondMenuGuid(secondMenu.getSecondMenuGuid());
                    secondMenuDto.setSecondMenuName(secondMenu.getName());
                    List<ThirdMenu> thirdMenuList = thirdMenuService.getBySecondMenuGuid(secondMenu.secondMenuGuid);
                    List<ThirdMenuDto> thirdMenuDtos = thirdMenuList.stream().map(p -> new ThirdMenuDto(p.thirdMenuGuid, p.name)).collect(Collectors.toList());
                    secondMenuDto.setThirdMenuList(thirdMenuDtos);
                    secondMenuDtoList.add(secondMenuDto);
                }
            }

            return BaseResponse.ok(result);
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }


    @PostMapping("/add_second_menu")
    public BaseResponse<SecondMenu> addSecondMenu(@RequestBody AddSecondMenuRequest request) {
        try {
            //1.根据菜单名找到母菜单
            Menu menu = menuService.getMenuByGuid(request.getMenuGuid());

            //2.判断是否已有同名子菜单
            List<SecondMenu> secondMenuList = secondMenuService.getSecondMenusByMenuGuid(menu.menuGuid);
            boolean existSecondMenu = secondMenuList.stream().map(p -> p.name).collect(Collectors.toList()).contains(request.getSecondMenuName());
            if (existSecondMenu) {
                return BaseResponse.failed("已有同名二级菜单，不能重复添加！");
            }

            //3.新增子菜单
            SecondMenu secondMenu = secondMenuService.addSecondMenu(menu.menuGuid, request.getSecondMenuName());

            return BaseResponse.ok(secondMenu);
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }


    @PostMapping("/add_third_menu")
    public BaseResponse<ThirdMenu> addSecondMenu(@RequestBody AddThirdMenuRequest request) {
        try {
            //1.根据菜单名找到母菜单
            SecondMenu secondMenu = secondMenuService.getSecondMenusBySecondMenuGuid(request.getSecondMenuGuid());

            //2.判断是否已有同名子菜单
            List<ThirdMenu> thirdMenuList = thirdMenuService.getBySecondMenuGuid(secondMenu.secondMenuGuid);
            boolean existThirdMenu = thirdMenuList.stream().map(p -> p.name).collect(Collectors.toList()).contains(request.getThirdMenuName());
            if (existThirdMenu) {
                return BaseResponse.failed("已有同名三级菜单，不能重复添加！");
            }

            //3.新增子菜单
            ThirdMenu thirdMenu = thirdMenuService.addThirdMenu(secondMenu.secondMenuGuid, request.getThirdMenuName());

            return BaseResponse.ok(thirdMenu);
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }
//
//    @PostMapping("/get_submenu_by_menu")
//    public BaseResponse<List<ThirdMenuDto>> getSubmenuList(@RequestBody GetSubmenuListRequest request) {
//        try {
//            //1.根据菜单名找到母菜单
//            Menu menu = menuService.getMenus(request.getMenuName(), requesuRet.getIdentity());
//
//            //2.根据母菜单找到子菜单
//            List<ThirdMenu> submenuList = submenuService.getSecondMenusByMenuGuid(menu.menuGuid);
//
//            return BaseResponse.ok(submenuList.stream().map(ThirdMenuDto::transform).collect(Collectors.toList()));
//        } catch (Exception e) {
//            return BaseResponse.failed(e.getLocalizedMessage());
//        }
//    }
}
