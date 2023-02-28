package com.model.request;


/**
 * @author wuyuxiao
 */

public class AddSecondMenuRequest {
    private String menuGuid;
    private String secondMenuName;
    private String identity;

    public String getSecondMenuName() {
        return secondMenuName;
    }

    public void setSecondMenuName(String secondMenuName) {
        this.secondMenuName = secondMenuName;
    }

    public String getMenuGuid() {
        return menuGuid;
    }

    public void setMenuGuid(String menuGuid) {
        this.menuGuid = menuGuid;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}