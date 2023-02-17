package com.persistence.entity;

import java.util.Date;
import java.sql.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * pre_built_party_organization 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("pre_built_party_organization")
public class PreBuiltPartyOrganization {

	@TableField(value = "id")
	public int id; 

	@TableField(value = "party_organization_name")
	public String partyOrganizationName; 

	@TableField(value = "party_organization_start_time")
	public String partyOrganizationStartTime; 

	@TableField(value = "approval_by")
	public String approvalBy; 

	@TableField(value = "subordination")
	public String subordination; 

	@TableField(value = "team")
	public String team; 

	@TableField(value = "identity")
	public String identity; 

	@TableField(value = "create_time")
	public Date createTime; 

	@TableField(value = "update_time")
	public Date updateTime; 

	@TableField(value = "deleted")
	public boolean deleted; 
}

