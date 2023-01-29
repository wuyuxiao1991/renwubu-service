package com.model.dto;

import java.util.List;

/**
 * @author wuyuxiao
 */
public class NewsDetail {
    String newsGuid;
    String title;
    String text;
    String submenuGuid;
    String submenuName;
    String deliverUserName;
    List<String> images;


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

    public String getSubmenuName() {
        return submenuName;
    }

    public void setSubmenuName(String submenuName) {
        this.submenuName = submenuName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubmenuGuid() {
        return submenuGuid;
    }

    public void setSubmenuGuid(String submenuGuid) {
        this.submenuGuid = submenuGuid;
    }

    public String getDeliverUserName() {
        return deliverUserName;
    }

    public void setDeliverUserName(String deliverUserName) {
        this.deliverUserName = deliverUserName;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}


