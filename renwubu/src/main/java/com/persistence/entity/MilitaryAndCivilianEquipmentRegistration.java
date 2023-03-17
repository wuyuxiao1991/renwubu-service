package com.persistence.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * military_and_civilian_equipment_registration 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("military_and_civilian_equipment_registration")
public class MilitaryAndCivilianEquipmentRegistration {

	@TableId(type = IdType.AUTO)
	Long id;

	@TableField(value = "equipment_name")
	public String equipmentName; 

	@TableField(value = "type")
	public String type; 

	@TableField(value = "unit")
	public String unit; 

	@TableField(value = "number")
	public String number; 

	@TableField(value = "purpose" )
	public String purpose;

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

	@TableField(value = "create_time", fill = FieldFill.INSERT)
	public LocalDateTime createTime;
	@TableField(value = "update_time", fill = FieldFill.UPDATE)
	public LocalDateTime updateTime;

	@TableField(value = "deleted")
	public boolean deleted; 
}

