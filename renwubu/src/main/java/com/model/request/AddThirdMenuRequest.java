package com.model.request;


/**
 * @author wuyuxiao
 */

public class AddThirdMenuRequest {
    private String secondMenuGuid;
    private String thirdMenuName;
    private String identity;

    public String getSecondMenuGuid() {
        return secondMenuGuid;
    }

    public void setSecondMenuGuid(String secondMenuGuid) {
        this.secondMenuGuid = secondMenuGuid;
    }

    public String getThirdMenuName() {
        return thirdMenuName;
    }

    public void setThirdMenuName(String thirdMenuName) {
        this.thirdMenuName = thirdMenuName;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}