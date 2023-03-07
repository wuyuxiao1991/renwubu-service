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
 * people_potential_registration 实体类
 * 2023-03-06 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("people_potential_registration")
public class PeoplePotentialRegistration {

	@TableField(value = "id")
	public int id; 

	@TableField(value = "organization_unit")
	public String organizationUnit; 

	@TableField(value = "name")
	public String name; 

	@TableField(value = "id_number")
	public String idNumber; 

	@TableField(value = "age")
	public String age; 

	@TableField(value = "sex")
	public String sex; 

	@TableField(value = "political_status")
	public String politicalStatus; 

	@TableField(value = "join_party_time")
	public String joinPartyTime; 

	@TableField(value = "education_level")
	public String educationLevel; 

	@TableField(value = "nationality")
	public String nationality; 

	@TableField(value = "health")
	public String health; 

	@TableField(value = "work")
	public String work; 

	@TableField(value = "work_property")
	public String workProperty; 

	@TableField(value = "position")
	public String position; 

	@TableField(value = "is_party_worker")
	public String isPartyWorker; 

	@TableField(value = "work_plcae")
	public String workPlcae; 

	@TableField(value = "household_place")
	public String householdPlace; 

	@TableField(value = "phone")
	public String phone; 

	@TableField(value = "military_status")
	public String militaryStatus; 

	@TableField(value = "is_college_student")
	public String isCollegeStudent; 

	@TableField(value = "enlistment_time")
	public String enlistmentTime; 

	@TableField(value = "retire_time")
	public String retireTime; 

	@TableField(value = "military_service_type")
	public String militaryServiceType; 

	@TableField(value = "military_major_name")
	public String militaryMajorName; 

	@TableField(value = "military_major_duration")
	public String militaryMajorDuration; 

	@TableField(value = "position_when_retire")
	public String positionWhenRetire; 

	@TableField(value = "rank_when_retire")
	public String rankWhenRetire; 

	@TableField(value = "local_major_name_1")
	public String localMajorName1; 

	@TableField(value = "technical_title_1")
	public String technicalTitle1; 

	@TableField(value = "local_major_duration_1")
	public String localMajorDuration1; 

	@TableField(value = "local_major_name_2")
	public String localMajorName2; 

	@TableField(value = "technical_title_2")
	public String technicalTitle2; 

	@TableField(value = "local_major_duration_2")
	public String localMajorDuration2; 

	@TableField(value = "identity")
	public String identity; 

	@TableField(value = "create_time")
	public Date createTime; 

	@TableField(value = "update_time")
	public Date updateTime; 
}

