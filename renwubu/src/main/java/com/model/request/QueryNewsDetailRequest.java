package com.model.request;


import lombok.Data;

/**
 * @author wuyuxiao
 */

public class QueryNewsDetailRequest {
    private String newsGuid;

    public String getNewsGuid() {
        return newsGuid;
    }

    public void setNewsGuid(String newsGuid) {
        this.newsGuid = newsGuid;
    }
}