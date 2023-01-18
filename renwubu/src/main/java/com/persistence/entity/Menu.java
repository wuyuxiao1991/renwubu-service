package com.persistence.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@TableName("menu")
public class Menu {

    @TableId(type = IdType.AUTO)
    Long id;

    @TableField(value = "menu_guid")
    public String menuGuid;
    @TableField(value = "name")
    String name;
    @TableField(value = "type")
    String type;
    @TableField(value = "identity")
    String identity;

    @TableField(value = "create_time")
    LocalDateTime createTime;
    @TableField(value = "update_time")
    LocalDateTime updateTime;
}