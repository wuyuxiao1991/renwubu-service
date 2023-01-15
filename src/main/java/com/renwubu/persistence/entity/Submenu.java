package com.renwubu.persistence.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
//@Data
@NoArgsConstructor
@Table(name = "submenu")
public
class Submenu {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "submenu_guid", nullable = false)
    String submenuGuid;

    @Column(name = "menu_guid", nullable = false)
    String menuGuid;

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "cover")
    String cover;

    @Column(name = "content")
    public String content;

    @Column(name = "create_time", nullable = false)
    LocalDateTime createTime;

    @Column(name = "update_time")
    LocalDateTime updateTime;

}