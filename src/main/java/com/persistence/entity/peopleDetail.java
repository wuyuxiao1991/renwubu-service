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
 * people_detail 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("people_detail")
public class PeopleDetail {

	@TableField(value = "id")
	public int id; 

	@TableField(value = "name")
	public String name; 

	@TableField(value = "rank")
	public String rank; 

	@TableField(value = "id_number")
	public String idNumber; 

	@TableField(value = "sex")
	public String sex; 

	@TableField(value = "political_status")
	public String politicalStatus; 

	@TableField(value = "education_level")
	public String educationLevel; 

	@TableField(value = "nationality")
	public String nationality; 

	@TableField(value = "health")
	public String health; 

	@TableField(value = "work")
	public String work; 

	@TableField(value = "work_type")
	public String workType; 

	@TableField(value = "position")
	public String position; 

	@TableField(value = "is_government_worker")
	public String isGovernmentWorker; 

	@TableField(value = "work_place")
	public String workPlace; 

	@TableField(value = "household_place")
	public String householdPlace; 

	@TableField(value = "phone")
	public String phone; 

	@TableField(value = "military_service_status")
	public String militaryServiceStatus; 

	@TableField(value = "is_student_in_college")
	public String isStudentInCollege; 

	@TableField(value = "enlistment time")
	public String enlistment time; 

	@TableField(value = "retire_time")
	public String retireTime; 

	@TableField(value = "type_of_military")
	public String typeOfMilitary; 

	@TableField(value = "military_major_name")
	public String militaryMajorName; 

	@TableField(value = "military_major_duration")
	public String militaryMajorDuration; 

	@TableField(value = "position_when_retire")
	public String positionWhenRetire; 

	@TableField(value = "millitary_rank_when_retire")
	public String millitaryRankWhenRetire; 

	@TableField(value = "local_profession_type_1")
	public String localProfessionType1; 

	@TableField(value = "local_profession_name_1")
	public String localProfessionName1; 

	@TableField(value = "technical_title_1")
	public String technicalTitle1; 

	@TableField(value = "profession_duration_1")
	public String professionDuration1; 

	@TableField(value = "local_profession_type_2")
	public String localProfessionType2; 

	@TableField(value = "local_profession_name_2")
	public String localProfessionName2; 

	@TableField(value = "technical_title_2")
	public String technicalTitle2; 

	@TableField(value = "profession_duration_2")
	public String professionDuration2; 

	@TableField(value = "direction")
	public String direction; 

	@TableField(value = "identity")
	public String identity; 

	@TableField(value = "create_time")
	public Date createTime; 

	@TableField(value = "update_time")
	public Date updateTime; 

	@TableField(value = "deleted")
	public boolean deleted; 
}

