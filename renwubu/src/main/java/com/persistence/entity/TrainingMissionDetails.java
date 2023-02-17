package com.persistence.entity;

import java.util.Date;
import java.sql.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TrainingMissionDetails 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingMissionDetails {

	private int id; 

	private String year; 

	private String province; 

	private String city; 

	private String district; 

	private String teamBranchName; 

	private String affiliation; 

	private String teamType; 

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

