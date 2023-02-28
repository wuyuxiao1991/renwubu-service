package com.model.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wuyuxiao
 */

public class NewsDto {
    String newsGuid;
    String title;
    String text;
    List<String> images;
    String deliverUserName;
    LocalDateTime createTime;

    public String getNewsGuid() {
        return newsGuid;
    }

    public void setNewsGuid(String newsGuid) {
        this.newsGuid = newsGuid;
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

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getImages() {
        return images;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}


