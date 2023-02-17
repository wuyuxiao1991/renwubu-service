package com.persistence.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.sql.*;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * military_service_registration 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("military_service_registration")
public class MilitaryServiceRegistration {

	@TableId(type = IdType.AUTO)
	Long id;

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

	@TableField(value = "create_time", fill = FieldFill.INSERT)
	public LocalDateTime createTime;
	@TableField(value = "create_time", fill = FieldFill.UPDATE)
	public LocalDateTime updateTime;
	@TableField(value = "deleted")
	public boolean deleted; 
}

