package com.model.request;


/**
 * @author wuyuxiao
 */

public class UploadExcelRequest {
    private String type;

    private String year;

    private String identity;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}