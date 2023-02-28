package com.model.dto;

import java.util.List;

/**
 * @author wuyuxiao
 */
public class MenuDto {
    String menuGuid;
    String menuName;
    List<SecondMenuDto> secondMenuDtos;

    public MenuDto() {

    }

    public MenuDto(String menuGuid, String menuName, List<SecondMenuDto> secondMenuDtos) {
        this.menuGuid = menuGuid;
        this.menuName = menuName;
        this.secondMenuDtos = secondMenuDtos;
    }

    public String getMenuGuid() {
        return menuGuid;
    }

    public void setMenuGuid(String menuGuid) {
        this.menuGuid = menuGuid;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<SecondMenuDto> getSecondMenuDtos() {
        return secondMenuDtos;
    }

    public void setSecondMenuDtos(List<SecondMenuDto> secondMenuDtos) {
        this.secondMenuDtos = secondMenuDtos;
    }
}

