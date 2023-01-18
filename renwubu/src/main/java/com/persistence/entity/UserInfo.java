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
@TableName("user_info")
public
class UserInfo {
    @TableId(type = IdType.AUTO)
    Long id;
    @TableField(value = "name")
    public String name;
    @TableField(value = "password")
    public String password;
    @TableField(value = "identity")
    //对应 IdentityEnum
    public String identity;
    @TableField(value = "create_time")
    public LocalDateTime createTime;
    @TableField(value = "update_time")
    public LocalDateTime updateTime;
}