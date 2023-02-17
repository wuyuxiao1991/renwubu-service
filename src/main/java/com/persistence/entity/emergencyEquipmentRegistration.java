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
 * emergency_equipment_registration 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("emergency_equipment_registration")
public class EmergencyEquipmentRegistration {

	@TableField(value = "id")
	public int id; 

	@TableField(value = "equipment_name")
	public String equipmentName; 

	@TableField(value = "type")
	public String type; 

	@TableField(value = "unit")
	public String unit; 

	@TableField(value = "number")
	public String number; 

	@TableField(value = "use")
	public String use; 

	@TableField(value = "warehousing_time")
	public String warehousingTime; 

	@TableField(value = "equipment_performance")
	public String equipmentPerformance; 

	@TableField(value = "storage_place")
	public String storagePlace; 

	@TableField(value = "management_unit")
	public String managementUnit; 

	@TableField(value = "dispatch_time")
	public String dispatchTime; 

	@TableField(value = "organization_type")
	public String organizationType; 

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

