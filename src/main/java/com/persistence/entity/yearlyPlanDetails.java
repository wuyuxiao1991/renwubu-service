package com.persistence.entity;

import java.util.Date;
import java.sql.*;
import lombok.Data;

/**
 * YearlyPlanDetails 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
public class YearlyPlanDetails {

	private int id; 

	private String year; 

	private String month; 

	private String affiliation; 

	private String teamBranch; 

	private String teamType; 

	private String isTaskTeam; 

	private String organizedHeadcount; 

	private String trainingHeadcount; 

	private String baseConcentratedTrainingTime; 

	private String otherTraningTime; 

	private String totalCount; 

	private String concentratedTrainingPlace; 

	private String identity; 

	private Date createTime; 

	private Date updateTime; 
}

