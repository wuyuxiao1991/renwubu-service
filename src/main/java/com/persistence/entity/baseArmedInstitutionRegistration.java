package com.persistence.entity;

import java.util.Date;
import java.sql.*;
import lombok.Data;

/**
 * BaseArmedInstitutionRegistration 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseArmedInstitutionRegistration {

	private int id; 

	private String name; 

	private String type; 

	private String place; 

	private String approvalBy; 

	private String managementRelation; 

	private String rank; 

	private String regionDistribution; 

	private String memo; 

	private String identity; 

	private Date createTime; 

	private Date updateTime; 
}

