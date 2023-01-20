package com.model.dto;

import com.alibaba.fastjson.JSON;
import com.persistence.entity.News;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author wuyuxiao
 */
@Data
public class NewsDto {
    String newsGuid;
    String title;
    String text;
    String deliverUserId;
    String deliverUserName;
    List<String> images;

//    public String getNewsGuid() {
//        return newsGuid;
//    }
//
//    public void setNewsGuid(String newsGuid) {
//        this.newsGuid = newsGuid;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
//    public List<String> getImages() {
//        return images;
//    }
//
//    public void setImages(List<String> images) {
//        this.images = images;
//    }
//
//    public String getDeliverUserId() {
//        return deliverUserId;
//    }
//
//    public void setDeliverUserId(String deliverUserId) {
//        this.deliverUserId = deliverUserId;
//    }
//
//    public String getDeliverUserName() {
//        return deliverUserName;
//    }
//
//    public void setDeliverUserName(String deliverUserName) {
//        this.deliverUserName = deliverUserName;
//    }
//
////    public NewsDto(String newsGuid, String title, String text, List<String> images,String deliverUserId ,String deliverUserName) {
////        this.newsGuid = newsGuid;
////        this.title = title;
////        this.text = text;
////        this.images = images;
////        this.deliverUserId=deliverUserId;
////        this.deliverUserName=deliverUserName;
////    }

    static public NewsDto transform(News news){
        NewsDto newsDto= new NewsDto();
        BeanUtils.copyProperties(news ,newsDto);
        newsDto.setImages(JSON.parseObject(news.images, List.class));
        return newsDto;
    }
}


