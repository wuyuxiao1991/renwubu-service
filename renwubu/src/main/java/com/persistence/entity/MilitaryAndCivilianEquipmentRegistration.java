package com.persistence.entity;

import java.util.Date;
import java.sql.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MilitaryAndCivilianEquipmentRegistration 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MilitaryAndCivilianEquipmentRegistration {

	private int id; 

	private String equipmentName; 

	private String type; 

	private String unit; 

	private String number; 

	private String use; 

	private String warehousingTime; 

	private String equipmentPerformance; 

	private String storagePlace; 

	private String managementUnit; 

	private String dispatchTime; 

	private String organizationType; 

	private String district; 

	private String identity; 

	private Date createTime; 

	private Date updateTime; 
}

