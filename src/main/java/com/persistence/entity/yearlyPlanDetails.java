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
 * yearly_plan_details 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("yearly_plan_details")
public class YearlyPlanDetails {

	@TableField(value = "id")
	public int id; 

	@TableField(value = "year")
	public String year; 

	@TableField(value = "month")
	public String month; 

	@TableField(value = "affiliation")
	public String affiliation; 

	@TableField(value = "team_branch")
	public String teamBranch; 

	@TableField(value = "team_type")
	public String teamType; 

	@TableField(value = "is_task_team")
	public String isTaskTeam; 

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

	@TableField(value = "create_time")
	public Date createTime; 

	@TableField(value = "update_time")
	public Date updateTime; 

	@TableField(value = "deleted")
	public boolean deleted; 
}

