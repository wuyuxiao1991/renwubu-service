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
 * military_strength_guarantee 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("military_strength_guarantee")
public class MilitaryStrengthGuarantee {

	@TableId(type = IdType.AUTO)
	Long id;

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

	@TableField(value = "create_time", fill = FieldFill.INSERT)
	public LocalDateTime createTime;
	@TableField(value = "update_time", fill = FieldFill.UPDATE)
	public LocalDateTime updateTime;
	@TableField(value = "deleted")
	public boolean deleted; 
}

