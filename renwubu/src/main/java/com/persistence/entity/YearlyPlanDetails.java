package com.persistence.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * yearly_plan_details 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("yearly_plan_details")
public class YearlyPlanDetails {

	@TableId(type = IdType.AUTO)
	Long id;

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

	@TableField(value = "other_training_time")
	public String otherTrainingTime;

	@TableField(value = "total_count")
	public String totalCount; 

	@TableField(value = "concentrated_training_place")
	public String concentratedTrainingPlace; 

	@TableField(value = "identity")
	public String identity;

	@TableField(value = "create_time", fill = FieldFill.INSERT)
	public LocalDateTime createTime;
	@TableField(value = "update_time", fill = FieldFill.UPDATE)
	public LocalDateTime updateTime;

	@TableField(value = "deleted")
	public boolean deleted; 
}

