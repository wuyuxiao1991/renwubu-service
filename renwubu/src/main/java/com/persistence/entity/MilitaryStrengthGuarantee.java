package com.persistence.entity;

import java.util.Date;
import java.sql.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MilitaryStrengthGuarantee 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MilitaryStrengthGuarantee {

	private int id; 

	private String registrationTask; 

	private String registrationPerson; 

	private String funds; 

	private String equipment; 

	private String memo; 

	private String district; 

	private String identity; 

	private Date createTime; 

	private Date updateTime; 
}

