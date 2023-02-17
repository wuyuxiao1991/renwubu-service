package com.persistence.entity;

import java.util.Date;
import java.sql.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MilitaryStrengthRegistration 实体类
 * 2023-02-17 wuyuxiao
 */ 

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MilitaryStrengthRegistration {

	private int id; 

	private String requiredBy; 

	private String taskType; 

	private String startToEndTime; 

	private String concreteTask; 

	private String requirementNumber; 

	private String taskPlace; 

	private String approvalBy; 

	private String approvalFileName; 

	private String issuedNumber; 

	private String commandUnit; 

	private String commandInfo; 

	private String fundsSource; 

	private String subsidyStandard; 

	private String equipmentRequirement; 

	private String totalPeopleForLooseUse; 

	private String totalPeopleDayForLooseUse; 

	private String normalPeopleForLooseUse; 

	private String normalPeopleDayForLooseUse; 

	private String jiganPeopleForLooseUse; 

	private String jiganPeopleDayForLooseUse; 

	private String newPowerPeopleForLooseUse; 

	private String newPowerPeopleDayForLooseUse; 

	private String totalTeamForSystemUse; 

	private String totalPeopleForSystemUse; 

	private String totalPeopleDayForSystemUse; 

	private String normalMinbingTeamNameForSystemUse; 

	private String normalMinbingPeopleForSystemUse; 

	private String normalMinbingPeopleDayForSystemUse; 

	private String jiganMinbingTeamNameForSystemUse; 

	private String jiganMinbingPeopleForSystemUse; 

	private String jiganMinbingPeopleDayForSystemUse; 

	private String newPowerPeopleForSystemUse; 

	private String newPowerPeopleDayForSystemUse; 

	private String totalDisptachEquipment; 

	private String lightWeapon; 

	private String observationEquipment; 

	private String communicationEquipment; 

	private String carEquipment; 

	private String engineeringEquipment; 

	private String chemicalPrevention;

	private String otherForDispatchEquipment; 

	private String totalForEmergencyEquipment; 

	private String antiTerrorismEquipment; 

	private String floodPreventionEquipment; 

	private String ruinsRescueEquipment; 

	private String forestFireFightingEquipment; 

	private String fightSnowEquipment; 

	private String riverSalvageEquipment; 

	private String helicopterEquipment; 

	private String shipboardEquipment; 

	private String carsForEmergencyEquipment; 

	private String engineeringForEmergencyEquipment; 

	private String uav; 

	private String othersForEmergencyEquipment; 

	private String transferPeopleCount; 

	private String rescuePeopleCount; 

	private String recoverEconomicLost; 

	private String transportationMaterials; 

	private String reinforceDyke; 

	private String earthworkExcavation; 

	private String putOutMountainFile; 

	private String otherOutput; 

	private String basicReusltOfsupportMilitary; 

	private String otherReusltOfSupportMilitary; 

	private String basicReusltOfMilitary; 

	private String otherReusltOfMilitary; 

	private String district; 

	private String identity; 

	private Date createTime; 

	private Date updateTime; 
}

