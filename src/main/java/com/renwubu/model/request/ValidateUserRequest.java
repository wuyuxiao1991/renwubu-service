package com.renwubu.model.request;

/**
 * @author wuyuxiao
 */
public class ValidateUserRequest {
    public String name;
    public String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
