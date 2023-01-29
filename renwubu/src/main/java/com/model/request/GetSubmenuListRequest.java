package com.model.request;


import lombok.Data;

/**
 * @author wuyuxiao
 */

public class GetSubmenuListRequest {
    private String menuName;
    private String identity;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
