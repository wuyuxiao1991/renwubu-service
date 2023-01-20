package com.persistence.entity;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.model.dto.NewsDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.List;


/**
 * @author wuyuxiao
 */
@Data
@NoArgsConstructor
@TableName("news")
public
class News {
    @TableId(type = IdType.AUTO)
    Long id;
    @TableField(value = "news_guid")
    public String newsGuid;
    @TableField(value = "submenu_guid")
    public String submenuGuid;
    @TableField(value = "title")
    public String title;
    @TableField(value = "text")
    public String text;
    @TableField(value = "images")
    public String images;
    @TableField(value = "deliver_user_id")
    public String deliverUserId;
    @TableField(value = "deliver_user_name")
    public String deliverUserName;
    @TableField(value = "create_time")
    LocalDateTime createTime;
    @TableField(value = "update_time")
    LocalDateTime updateTime;
}