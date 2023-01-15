package com.renwubu.persistence.entity;


import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author wuyuxiao
 */
@Entity
@NoArgsConstructor
@Table(name = "user_info")
public
class UserInfo {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "password", nullable = false)
    public String password;

    @Column(name = "authority")
    //对应 IdentityEnum
    public String identity;

    @Column(name = "create_time", nullable = false)
    public LocalDateTime createTime;

    @Column(name = "update_time")
    public LocalDateTime updateTime;
}