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
 * equipment_potential_registration 实体类
 * 2023-03-06 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("equipment_potential_registration")
public class EquipmentPotentialRegistration {

	@TableField(value = "id")
	public int id; 

	@TableField(value = "name")
	public String name; 

	@TableField(value = "major_property")
	public String majorProperty;

	@TableField(value = "number")
	public String number; 

	@TableField(value = "technical_status")
	public String technicalStatus; 

	@TableField(value = "storage_place")
	public String storagePlace; 

	@TableField(value = "keep_organization")
	public String keepOrganization; 

	@TableField(value = "contact_person")
	public String contactPerson; 

	@TableField(value = "contact_method")
	public String contactMethod; 

	@TableField(value = "identity")
	public String identity; 

	@TableField(value = "create_time")
	public Date createTime; 

	@TableField(value = "update_time")
	public Date updateTime;

	@TableField(value = "deleted")
	public Boolean deleted;
}

