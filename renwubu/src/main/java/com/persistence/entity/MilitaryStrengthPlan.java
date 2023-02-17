package com.persistence.entity;

import java.util.Date;
import java.sql.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MilitaryStrengthPlan 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MilitaryStrengthPlan {

	private int id; 

	private String planName; 

	private String executeTaskRegion; 

	private String type; 

	private String siteOrganizer; 

	private String relatedGuarantee; 

	private String staffSize; 

	private String equipmentSize; 

	private String district; 

	private String identity; 

	private Date createTime; 

	private Date updateTime; 
}

