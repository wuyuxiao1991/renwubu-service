package com.persistence.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * pre_built_party_organization 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("pre_build_party_organization")
public class PreBuildPartyOrganization {
	@TableId(type = IdType.AUTO)
	Long id;

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

	@TableField(value = "create_time", fill = FieldFill.INSERT)
	public LocalDateTime createTime;
	@TableField(value = "update_time", fill = FieldFill.UPDATE)
	public LocalDateTime updateTime;

	@TableField(value = "deleted")
	public boolean deleted; 
}

