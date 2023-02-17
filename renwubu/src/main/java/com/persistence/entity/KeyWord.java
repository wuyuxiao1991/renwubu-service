package com.persistence.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * key_word 实体类
 * 2023-02-17 wuyuxiao
 * @author wuyuxiao
 * */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("key_word")
public class KeyWord {

	@TableId(type = IdType.AUTO)
	Long id;


	@TableField(value = "table")
	public String table;

	@TableField(value = "key_word")
	public String keyWord;

	@TableField(value = "identity")
	public String identity;

	@TableField(value = "create_time", fill = FieldFill.INSERT)
	public LocalDateTime createTime;
	@TableField(value = "create_time", fill = FieldFill.UPDATE)
	public LocalDateTime updateTime;

	@TableField(value = "deleted")
	public boolean deleted; 
}

