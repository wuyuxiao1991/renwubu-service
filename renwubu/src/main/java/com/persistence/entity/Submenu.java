package com.persistence.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


/**
 * @author wuyuxiao
 */
@NoArgsConstructor
@TableName("submenu")
public
class Submenu {

    @TableId(type = IdType.AUTO)
    Long id;

    @TableField(value = "submenu_guid" )
    public String submenuGuid;

    @TableField(value = "menu_guid" )
    public String menuGuid;

    @TableField(value = "name" )
    public String name;

    @TableField(value = "create_time" )
    public LocalDateTime createTime;

    @TableField(value = "update_time" )
    public LocalDateTime updateTime;

}