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
 * base_armed_institution_registration 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("base_armed_institution_registration")
public class BaseArmedInstitutionRegistration {

	@TableField(value = "id")
	public int id; 

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

	@TableField(value = "rank")
	public String rank; 

	@TableField(value = "region_distribution")
	public String regionDistribution; 

	@TableField(value = "memo")
	public String memo; 

	@TableField(value = "identity")
	public String identity; 

	@TableField(value = "create_time")
	public Date createTime; 

	@TableField(value = "update_time")
	public Date updateTime; 

	@TableField(value = "deleted")
	public boolean deleted; 
}

