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
 * base_armed_institution_registration 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("base_armed_institution_registration")
public class BaseArmedInstitutionRegistration {

	@TableId(type = IdType.AUTO)
	Long id;

	@TableField(value = "name")
	public String name; 

	@TableField(value = "type")
	public String type; 

	@TableField(value = "place")
	public String place; 

	@TableField(value = "approval_by")
	public String approvalBy; 

	@TableField(value = "management_relation")
	public String managementRelation; 

	@TableField(value = "level")
	public String level;

	@TableField(value = "region_distribution")
	public String regionDistribution; 

	@TableField(value = "memo")
	public String memo; 

	@TableField(value = "identity")
	public String identity;

	@TableField(value = "create_time", fill = FieldFill.INSERT)
	public LocalDateTime createTime;
	@TableField(value = "create_time", fill = FieldFill.UPDATE)
	public LocalDateTime updateTime;

	@TableField(value = "deleted")
	public boolean deleted; 
}

