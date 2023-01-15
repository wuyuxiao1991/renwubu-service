package com.renwubu.model.request;



/**
 * @author wuyuxiao
 */

public class GetMenuRequest {
    private String name;
    private String identity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}