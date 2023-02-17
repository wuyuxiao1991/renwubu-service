package com.persistence.entity;

import java.util.Date;
import java.sql.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MinbingLeaderRegistration 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MinbingLeaderRegistration {

	private int id; 

	private String work; 

	private String position; 

	private String name; 

	private String sex; 

	private String idNumber; 

	private String politicalStatus; 

	private String educationLevel; 

	private String phone; 

	private String birthDate; 

	private String partyTime; 

	private String workDuration; 

	private String mianrenUnit; 

	private String isInMinbing; 

	private String teamNameAndPosition; 

	private String partyWorkTime; 

	private String isRetireMilitary; 

	private String enlistmentTime; 

	private String retireTime; 

	private String durationOfMilitary; 

	private String typeOfMilitaryService; 

	private String positionWhenRetire; 

	private String isTrainedInRenwuSchool; 

	private String isPass; 

	private String qualificationTimeAndUnit; 

	private String trainingSituation; 

	private String testResult; 

	private String taskExecution; 

	private String rewardAndPunishment; 

	private String resume; 

	private String parttimeNumber; 

	private String parttimeWork; 

	private String identity; 

	private Date createTime; 

	private Date updateTime; 
}

