package com.persistence.entity;

import java.util.Date;
import java.sql.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PeopleDetail 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeopleDetail {

	private int id; 

	private String name; 

	private String rank; 

	private String idNumber; 

	private String sex; 

	private String politicalStatus; 

	private String educationLevel; 

	private String nationality; 

	private String health; 

	private String work; 

	private String workType; 

	private String position; 

	private String isGovernmentWorker; 

	private String workPlace; 

	private String householdPlace; 

	private String phone; 

	private String militaryServiceStatus; 

	private String isStudentInCollege; 

	private String enlistmentTime;

	private String retireTime; 

	private String typeOfMilitary; 

	private String militaryMajorName; 

	private String militaryMajorDuration; 

	private String positionWhenRetire; 

	private String millitaryRankWhenRetire; 

	private String localProfessionType1; 

	private String localProfessionName1; 

	private String technicalTitle1; 

	private String professionDuration1; 

	private String localProfessionType2; 

	private String localProfessionName2; 

	private String technicalTitle2; 

	private String professionDuration2; 

	private String direction; 

	private String identity; 

	private Date createTime; 

	private Date updateTime; 
}

