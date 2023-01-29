package com.persistence.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author wuyuxiao
 */

@NoArgsConstructor
@TableName("user_info")
public
class UserInfo {
    @TableId(type = IdType.AUTO)
    Long id;
    @TableField(value = "user_guid")
    public String userGuid;
    @TableField(value = "name")
    public String name;
    @TableField(value = "password")
    public String password;
    @TableField(value = "identity")
    public String identity;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    public LocalDateTime createTime;
    @TableField(value = "create_time", fill = FieldFill.UPDATE)
    public LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}