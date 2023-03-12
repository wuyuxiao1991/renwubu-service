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
 * military_strength_registration 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("military_strength_registration")
public class MilitaryStrengthRegistration {

	@TableId(type = IdType.AUTO)
	public Long id;

	@TableField(value = "required_by")
	public String requiredBy; 

	@TableField(value = "task_type")
	public String taskType; 

	@TableField(value = "start_to_end_time")
	public String startToEndTime; 

	@TableField(value = "concrete_task")
	public String concreteTask; 

	@TableField(value = "requirement_number")
	public String requirementNumber; 

	@TableField(value = "task_place")
	public String taskPlace; 

	@TableField(value = "approval_by")
	public String approvalBy; 

	@TableField(value = "approval_file_name")
	public String approvalFileName; 

	@TableField(value = "issued_number")
	public String issuedNumber; 

	@TableField(value = "command_unit")
	public String commandUnit; 

	@TableField(value = "command_info")
	public String commandInfo; 

	@TableField(value = "funds_source")
	public String fundsSource; 

	@TableField(value = "subsidy_standard")
	public String subsidyStandard; 

	@TableField(value = "equipment_requirement")
	public String equipmentRequirement; 

	@TableField(value = "total_people_for_loose_use")
	public String totalPeopleForLooseUse; 

	@TableField(value = "total_people_day_for_loose_use")
	public String totalPeopleDayForLooseUse; 

	@TableField(value = "normal_people_for_loose_use")
	public String normalPeopleForLooseUse; 

	@TableField(value = "normal_people_day_for_loose_use")
	public String normalPeopleDayForLooseUse; 

	@TableField(value = "jigan_people_for_loose_use")
	public String jiganPeopleForLooseUse; 

	@TableField(value = "jigan_people_day_for_loose_use")
	public String jiganPeopleDayForLooseUse; 

	@TableField(value = "new_power_people_for_loose_use")
	public String newPowerPeopleForLooseUse; 

	@TableField(value = "new_power_people_day_for_loose_use")
	public String newPowerPeopleDayForLooseUse; 

	@TableField(value = "total_team_for_system_use")
	public String totalTeamForSystemUse; 

	@TableField(value = "total_people_for_system_use")
	public String totalPeopleForSystemUse; 

	@TableField(value = "total_people_day_for_system_use")
	public String totalPeopleDayForSystemUse; 

	@TableField(value = "normal_minbing_team_name_for_system_use")
	public String normalMinbingTeamNameForSystemUse; 

	@TableField(value = "normal_minbing_people_for_system_use")
	public String normalMinbingPeopleForSystemUse; 

	@TableField(value = "normal_minbing_people_day_for_system_use")
	public String normalMinbingPeopleDayForSystemUse; 

	@TableField(value = "jigan_minbing_team_name_for_system_use")
	public String jiganMinbingTeamNameForSystemUse; 

	@TableField(value = "jigan_minbing_people_for_system_use")
	public String jiganMinbingPeopleForSystemUse; 

	@TableField(value = "jigan_minbing_people_day_for_system_use")
	public String jiganMinbingPeopleDayForSystemUse; 

	@TableField(value = "new_power_people_for_system_use")
	public String newPowerPeopleForSystemUse; 

	@TableField(value = "new_power_people_day_for_system_use")
	public String newPowerPeopleDayForSystemUse; 

	@TableField(value = "total_disptach_equipment")
	public String totalDisptachEquipment; 

	@TableField(value = "light_weapon")
	public String lightWeapon; 

	@TableField(value = "observation_equipment")
	public String observationEquipment; 

	@TableField(value = "communication_equipment")
	public String communicationEquipment; 

	@TableField(value = "car_equipment")
	public String carEquipment; 

	@TableField(value = "engineering_equipment")
	public String engineeringEquipment; 

	@TableField(value = "chemical_prevention")
	public String chemicalPrevention;

	@TableField(value = "other_for_dispatch_equipment")
	public String otherForDispatchEquipment; 

	@TableField(value = "total_for_emergency_equipment")
	public String totalForEmergencyEquipment; 

	@TableField(value = "anti_terrorism_equipment")
	public String antiTerrorismEquipment; 

	@TableField(value = "flood_prevention_equipment")
	public String floodPreventionEquipment; 

	@TableField(value = "ruins_rescue_equipment")
	public String ruinsRescueEquipment; 

	@TableField(value = "forest_fire_fighting_equipment")
	public String forestFireFightingEquipment; 

	@TableField(value = "fight_snow_equipment")
	public String fightSnowEquipment; 

	@TableField(value = "river_salvage_equipment")
	public String riverSalvageEquipment; 

	@TableField(value = "helicopter_equipment")
	public String helicopterEquipment; 

	@TableField(value = "shipboard_equipment")
	public String shipboardEquipment; 

	@TableField(value = "cars_for_emergency_equipment")
	public String carsForEmergencyEquipment; 

	@TableField(value = "engineering_for_emergency_equipment")
	public String engineeringForEmergencyEquipment; 

	@TableField(value = "uav")
	public String uav; 

	@TableField(value = "others_for_emergency_equipment")
	public String othersForEmergencyEquipment; 

	@TableField(value = "transfer_people_count")
	public String transferPeopleCount; 

	@TableField(value = "rescue_people_count")
	public String rescuePeopleCount; 

	@TableField(value = "recover_economic_lost")
	public String recoverEconomicLost; 

	@TableField(value = "transportation_materials")
	public String transportationMaterials; 

	@TableField(value = "reinforce_dyke")
	public String reinforceDyke; 

	@TableField(value = "earthwork_excavation")
	public String earthworkExcavation; 

	@TableField(value = "put_out_mountain_file")
	public String putOutMountainFile; 

	@TableField(value = "other_output")
	public String otherOutput; 

	@TableField(value = "basic_result_of_support_military")
	public String basicResultOfSupportMilitary;

	@TableField(value = "other_result_of_support_military")
	public String otherResultOfSupportMilitary;

	@TableField(value = "basic_result_of_military")
	public String basicResultOfMilitary;

	@TableField(value = "other_result_of_military")
	public String otherResultOfMilitary;

	@TableField(value = "district")
	public String district; 

	@TableField(value = "identity")
	public String identity;

	@TableField(value = "create_time", fill = FieldFill.INSERT)
	public LocalDateTime createTime;
	@TableField(value = "create_time", fill = FieldFill.UPDATE)
	public LocalDateTime updateTime;

	@TableField(value = "deleted")
	public boolean deleted; 
}

