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
 * military_service_registration 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("military_service_registration")
public class MilitaryServiceRegistration {

	@TableField(value = "id")
	public int id; 

	@TableField(value = "id_number")
	public String idNumber; 

	@TableField(value = "name")
	public String name; 

	@TableField(value = "sex")
	public String sex; 

	@TableField(value = "birth_date")
	public String birthDate; 

	@TableField(value = "household_place")
	public String householdPlace; 

	@TableField(value = "work_place")
	public String workPlace; 

	@TableField(value = "receipt_confirmation")
	public String receiptConfirmation; 

	@TableField(value = "status")
	public String status; 

	@TableField(value = "identity")
	public String identity; 

	@TableField(value = "create_time")
	public Date createTime; 

	@TableField(value = "update_time")
	public Date updateTime; 

	@TableField(value = "deleted")
	public boolean deleted; 
}

