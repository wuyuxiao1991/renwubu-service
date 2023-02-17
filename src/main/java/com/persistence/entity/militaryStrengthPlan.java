package com.persistence.entity;

import java.util.Date;
import java.sql.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * military_strength_plan 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("military_strength_plan")
public class MilitaryStrengthPlan {

	@TableField(value = "id")
	public int id; 

	@TableField(value = "plan_name")
	public String planName; 

	@TableField(value = "execute_task_region")
	public String executeTaskRegion; 

	@TableField(value = "type")
	public String type; 

	@TableField(value = "site_organizer")
	public String siteOrganizer; 

	@TableField(value = "related_guarantee")
	public String relatedGuarantee; 

	@TableField(value = "staff_size")
	public String staffSize; 

	@TableField(value = "equipment_size")
	public String equipmentSize; 

	@TableField(value = "district")
	public String district; 

	@TableField(value = "identity")
	public String identity; 

	@TableField(value = "create_time")
	public Date createTime; 

	@TableField(value = "update_time")
	public Date updateTime; 

	@TableField(value = "deleted")
	public boolean deleted; 
}

