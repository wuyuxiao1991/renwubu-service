package com.model.dto;

import java.util.List;

/**
 * @author wuyuxiao
 */
public class NewsDto {
    String newsGuid;
    String title;
    String text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public NewsDto(String newsGuid, String title, String text, List<String> images) {
        this.newsGuid = newsGuid;
        this.title = title;
        this.text = text;
        this.images = images;
    }
}


