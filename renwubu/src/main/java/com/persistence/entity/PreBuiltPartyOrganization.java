package com.persistence.entity;

import java.util.Date;
import java.sql.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PreBuiltPartyOrganization 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreBuiltPartyOrganization {

	private int id; 

	private String partyOrganizationName; 

	private String partyOrganizationStartTime; 

	private String approvalBy; 

	private String subordination; 

	private String team; 

	private String identity; 

	private Date createTime; 

	private Date updateTime; 
}

