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
 * military_strength_guarantee 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("military_strength_guarantee")
public class MilitaryStrengthGuarantee {

	@TableField(value = "id")
	public int id; 

	@TableField(value = "registration_task")
	public String registrationTask; 

	@TableField(value = "registration_person")
	public String registrationPerson; 

	@TableField(value = "funds")
	public String funds; 

	@TableField(value = "equipment")
	public String equipment; 

	@TableField(value = "memo")
	public String memo; 

	@TableField(value = "district")
	public String district; 

	@TableField(value = "identity")
	public String identity; 

	@TableField(value = "create_time")
	public Date createTime; 

	@TableField(value = "update_time")
	public Date updateTime; 

	@TableField(value = "deleted")
	public boolean deleted; 
}

