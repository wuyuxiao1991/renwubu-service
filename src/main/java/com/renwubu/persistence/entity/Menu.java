package com.renwubu.persistence.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
//@Data
@NoArgsConstructor
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    @TableId(type = IdType.AUTO)
    Long id;

    @Column(name = "menu_guid", nullable = false)
    public String menuGuid;

    @Column(name = "menu_name", nullable = false)
    String menuName;

    @Column(name = "menu_type", nullable = false)
    String menuType;

    @Column(name = "identity", nullable = false)
    String identity;

    @Column(name = "create_time", nullable = false)
    LocalDateTime createTime;

    @Column(name = "update_time")
    LocalDateTime updateTime;
}