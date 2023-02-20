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
 * zhuanwu_leader_registration 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("zhuanwu_leader_registration")
public class ZhuanwuLeaderRegistration {

	@TableId(type = IdType.AUTO)
	Long id;

	@TableField(value = "work")
	public String work; 

	@TableField(value = "position")
	public String position; 

	@TableField(value = "name")
	public String name; 

	@TableField(value = "sex")
	public String sex; 

	@TableField(value = "id_number")
	public String idNumber; 

	@TableField(value = "political_status")
	public String politicalStatus; 

	@TableField(value = "education_level")
	public String educationLevel; 

	@TableField(value = "phone")
	public String phone; 

	@TableField(value = "birth_date")
	public String birthDate; 

	@TableField(value = "party_time")
	public String partyTime; 

	@TableField(value = "work_duration")
	public String workDuration; 

	@TableField(value = "mianren_unit")
	public String mianrenUnit; 

	@TableField(value = "is_in_minbing")
	public String isInMinbing; 

	@TableField(value = "team_name_and_position")
	public String teamNameAndPosition; 

	@TableField(value = "party_work_time")
	public String partyWorkTime; 

	@TableField(value = "is_retire_military")
	public String isRetireMilitary; 

	@TableField(value = "enlistment_time")
	public String enlistmentTime; 

	@TableField(value = "retire_time")
	public String retireTime; 

	@TableField(value = "duration_of_military")
	public String durationOfMilitary; 

	@TableField(value = "type_of_military_service")
	public String typeOfMilitaryService; 

	@TableField(value = "position_when_retire")
	public String positionWhenRetire; 

	@TableField(value = "is_trained_in_renwu_school")
	public String isTrainedInRenwuSchool; 

	@TableField(value = "is_pass")
	public String isPass; 

	@TableField(value = "qualification_time_and_unit")
	public String qualificationTimeAndUnit; 

	@TableField(value = "training_situation")
	public String trainingSituation; 

	@TableField(value = "test_result")
	public String testResult; 

	@TableField(value = "task_execution")
	public String taskExecution; 

	@TableField(value = "reward_and_punishment")
	public String rewardAndPunishment; 

	@TableField(value = "resume")
	public String resume; 

	@TableField(value = "parttime_number")
	public String parttimeNumber; 

	@TableField(value = "parttime_work")
	public String parttimeWork; 

	@TableField(value = "identity")
	public String identity;

	@TableField(value = "deleted")
	public boolean deleted;

	@TableField(value = "create_time", fill = FieldFill.INSERT)
	public LocalDateTime createTime;
	@TableField(value = "create_time", fill = FieldFill.UPDATE)
	public LocalDateTime updateTime;
}

