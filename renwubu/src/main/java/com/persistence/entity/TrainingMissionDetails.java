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
 * training_mission_details 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("training_mission_details")
public class TrainingMissionDetails {
	@TableId(type = IdType.AUTO)
	Long id;

	@TableField(value = "year")
	public String year; 

	@TableField(value = "province")
	public String province; 

	@TableField(value = "city")
	public String city; 

	@TableField(value = "district")
	public String district; 

	@TableField(value = "team_branch_name")
	public String teamBranchName; 

	@TableField(value = "affiliation")
	public String affiliation; 

	@TableField(value = "team_type")
	public String teamType; 

	@TableField(value = "organized_headcount")
	public String organizedHeadcount; 

	@TableField(value = "training_headcount")
	public String trainingHeadcount; 

	@TableField(value = "base_concentrated_training_time")
	public String baseConcentratedTrainingTime; 

	@TableField(value = "other_traning_time")
	public String otherTraningTime; 

	@TableField(value = "total_count")
	public String totalCount; 

	@TableField(value = "concentrated_training_place")
	public String concentratedTrainingPlace; 

	@TableField(value = "identity")
	public String identity;
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	public LocalDateTime createTime;
	@TableField(value = "create_time", fill = FieldFill.UPDATE)
	public LocalDateTime updateTime;

	@TableField(value = "deleted")
	public boolean deleted; 
}

