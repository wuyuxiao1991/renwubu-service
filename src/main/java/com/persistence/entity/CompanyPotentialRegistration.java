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
 * company_potential_registration 实体类
 * 2023-03-06 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("company_potential_registration")
public class CompanyPotentialRegistration {

	@TableField(value = "id")
	public int id; 

	@TableField(value = "name")
	public String name; 

	@TableField(value = "unique_code")
	public String uniqueCode; 

	@TableField(value = "work_plcae")
	public String workPlcae; 

	@TableField(value = "work_detailed_address")
	public String workDetailedAddress; 

	@TableField(value = "contact_person")
	public String contactPerson; 

	@TableField(value = "contact_method")
	public String contactMethod; 

	@TableField(value = "property")
	public String property; 

	@TableField(value = "industry")
	public String industry; 

	@TableField(value = "party_organization_building")
	public String partyOrganizationBuilding; 

	@TableField(value = "business")
	public String business; 

	@TableField(value = "male_employee_number")
	public String maleEmployeeNumber; 

	@TableField(value = "female_employee_number")
	public String femaleEmployeeNumber; 

	@TableField(value = "equipment_name")
	public String equipmentName; 

	@TableField(value = "equipment_manjor_property")
	public String equipmentManjorProperty; 

	@TableField(value = "equipment_number")
	public String equipmentNumber; 

	@TableField(value = "professional_direction")
	public String professionalDirection; 

	@TableField(value = "professional_people_count")
	public String professionalPeopleCount; 

	@TableField(value = "has_business_armed_force")
	public String hasBusinessArmedForce; 

	@TableField(value = "identity")
	public String identity; 

	@TableField(value = "create_time")
	public Date createTime; 

	@TableField(value = "update_time")
	public Date updateTime; 
}

