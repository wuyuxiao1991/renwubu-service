package com.persistence.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


/**
 * @author wuyuxiao
 */
@NoArgsConstructor
@AllArgsConstructor
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

    @TableField(value = "create_time", fill = FieldFill.INSERT )
    public LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.UPDATE )
    public LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubmenuGuid() {
        return submenuGuid;
    }

    public void setSubmenuGuid(String submenuGuid) {
        this.submenuGuid = submenuGuid;
    }

    public String getMenuGuid() {
        return menuGuid;
    }

    public void setMenuGuid(String menuGuid) {
        this.menuGuid = menuGuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}