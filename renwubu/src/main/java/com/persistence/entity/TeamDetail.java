package com.persistence.entity;

import java.util.Date;
import java.sql.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TeamDetail 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDetail {

	private int id; 

	private String name; 

	private String type; 

	private String task; 

	private String professionalType; 

	private String numberOfPeople; 

	private Date formationTime; 

	private String identity; 

	private Date createTime; 

	private Date updateTime; 
}

