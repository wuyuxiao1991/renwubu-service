package com.persistence.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.sql.*;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * team_detail 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("team_detail")
public class TeamDetail {

	@TableId(type = IdType.AUTO)
	Long id;

	@TableField(value = "name")
	public String name; 

	@TableField(value = "type")
	public String type; 

	@TableField(value = "task")
	public String task; 

	@TableField(value = "professional_type")
	public String professionalType; 

	@TableField(value = "number_of_people")
	public String numberOfPeople; 

	@TableField(value = "formation_time")
	public Date formationTime; 

	@TableField(value = "identity")
	public String identity;

	@TableField(value = "create_time", fill = FieldFill.INSERT)
	public LocalDateTime createTime;
	@TableField(value = "update_time", fill = FieldFill.UPDATE)
	public LocalDateTime updateTime;

	@TableField(value = "deleted")
	public boolean deleted; 
}

