package com.model.request;


import lombok.Data;

/**
 * @author wuyuxiao
 */

public class DeleteNewsRequest {
    private String newsGuid;

    public String getNewsGuid() {
        return newsGuid;
    }

    public void setNewsGuid(String newsGuid) {
        this.newsGuid = newsGuid;
    }
}