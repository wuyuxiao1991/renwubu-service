package com.persistence.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


/**
 * @author wuyuxiao
 */
@NoArgsConstructor
@TableName("news")
public
class News {
    @TableId(type = IdType.AUTO)
    Long id;
    @TableField(value = "news_guid")
    public String newsGuid;
    @TableField(value = "third_menu_guid")
    public String thirdMenuGuid;
    @TableField(value = "title")
    public String title;
    @TableField(value = "text")
    public String text;
    @TableField(value = "images")
    public String images;
    @TableField(value = "deliver_user_name")
    public String deliverUserName;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    public LocalDateTime createTime;
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    public LocalDateTime updateTime;
    @TableField(value = "deleted")
    public Boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getThirdMenuGuid() {
        return thirdMenuGuid;
    }

    public void setThirdMenuGuid(String thirdMenuGuid) {
        this.thirdMenuGuid = thirdMenuGuid;
    }

    public String getDeliverUserName() {
        return deliverUserName;
    }

    public void setDeliverUserName(String deliverUserName) {
        this.deliverUserName = deliverUserName;
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

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getNewsGuid() {
        return newsGuid;
    }

    public void setNewsGuid(String newsGuid) {
        this.newsGuid = newsGuid;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}