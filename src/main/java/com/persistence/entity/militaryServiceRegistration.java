package com.persistence.entity;

import java.util.Date;
import java.sql.*;
import lombok.Data;

/**
 * MilitaryServiceRegistration 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MilitaryServiceRegistration {

	private int id; 

	private String idNumber; 

	private String name; 

	private String sex; 

	private String birthDate; 

	private String householdPlace; 

	private String workPlace; 

	private String receiptConfirmation; 

	private String status; 

	private String identity; 

	private Date createTime; 

	private Date updateTime; 
}

