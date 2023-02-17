package cn.kt.springboot_cruddemo.domain;

import java.util.Date;
import java.sql.*;
import lombok.Data;

/**
 * aryAndCivilianEquipmentRegistration 实体类
 * 2023-02-16 lvyYu
 */ 

@Data
public class aryAndCivilianEquipmentRegistration {

	private int id;//id 

	private String equipment_name;//equipment_name 

	private String type;//type 

	private String unit;//unit 

	private String number;//number 

	private String use;//use 

	private String warehousing_time;//warehousing_time 

	private String equipment_performance;//equipment_performance 

	private String storage_place;//storage_place 

	private String management_unit;//management_unit 

	private String dispatch_time;//dispatch_time 

	private String organization_type;//organization_type 

	private String district;//district 

	private String identity;//identity 

	private Date create_time;//create_time 

	private Date update_time;//update_time 
}

