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
@TableName("third_menu")
public
class ThirdMenu {

    @TableId(type = IdType.AUTO)
    Long id;

    @TableField(value = "third_menu_guid" )
    public String thirdMenuGuid;

    @TableField(value = "second_menu_guid" )
    public String secondMenuGuid;

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

    public String getThirdMenuGuid() {
        return thirdMenuGuid;
    }

    public void setThirdMenuGuid(String thirdMenuGuid) {
        this.thirdMenuGuid = thirdMenuGuid;
    }

    public String getSecondMenuGuid() {
        return secondMenuGuid;
    }

    public void setSecondMenuGuid(String secondMenuGuid) {
        this.secondMenuGuid = secondMenuGuid;
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