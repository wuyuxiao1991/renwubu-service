package com.model.dto;

import java.time.LocalDateTime;

/**
 * @author wuyuxiao
 */

public class NewsDto {
    String newsGuid;
    String title;
    String submenuName;
    String deliverUserName;
    LocalDateTime createTime;

    public String getNewsGuid() {
        return newsGuid;
    }

    public void setNewsGuid(String newsGuid) {
        this.newsGuid = newsGuid;
    }

    public String getSubmenuName() {
        return submenuName;
    }

    public void setSubmenuName(String submenuName) {
        this.submenuName = submenuName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeliverUserName() {
        return deliverUserName;
    }

    public void setDeliverUserName(String deliverUserName) {
        this.deliverUserName = deliverUserName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}


