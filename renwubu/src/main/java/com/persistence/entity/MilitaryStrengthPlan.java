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
 * military_strength_plan 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("military_strength_plan")
public class MilitaryStrengthPlan {

	@TableId(type = IdType.AUTO)
	Long id;
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

	@TableField(value = "create_time", fill = FieldFill.INSERT)
	public LocalDateTime createTime;
	@TableField(value = "create_time", fill = FieldFill.UPDATE)
	public LocalDateTime updateTime;
	@TableField(value = "deleted")
	public boolean deleted; 
}

