package com.model.request;


/**
 * @author wuyuxiao
 */

public class DownloadExcelRequest {
    public String type;

    private String identity;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}