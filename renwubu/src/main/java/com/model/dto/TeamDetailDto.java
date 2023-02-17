package com.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * TeamDetail 实体类
 * @author wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDetailDto {
	private String name; 

	private String type; 

	private String task; 

	private String professionalType; 

	private String numberOfPeople; 

	private Date formationTime; 

	private String identity;
}

