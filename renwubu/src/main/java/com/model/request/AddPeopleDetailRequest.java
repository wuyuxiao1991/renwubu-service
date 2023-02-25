package com.model.request;

import net.bytebuddy.implementation.bytecode.assign.TypeCasting;

/**
 * @author KevinMite-Lyh
 */

public class AddPeopleDetailRequest {
	// 把字段设置为私有属性，可以避免外部直接访问字段，同时又能在方法中进行限制这些参数，防止用户输入的不规范
	// 在setField方法中可进行修改参数，getField方法中获取field属性值
    private String name;
    private String rank;
    private String idNumber;
    private String sex;
    private String politicalStatus;
    private String nationality;
    private String health;
	private String work;
	private String workType;
	private String position;
	private String isGovernmentWorker;
	private String workPlace;
	private String householdPlace;
	private String phone;
	private String militaryServiceStatus;
	private String isStudentInCollege;
	private String enlistmentTime;
	private String retireTime;
	private String typeOfMilitary;
	private String militaryMajorName;
	private String militaryMajorDuration;
	private String positionWhenRetire;
	private String militaryRankWhenRetire;
	private String localProfessionType1;
	private String localProfessionName1;

	private String technicalTitle1;
	private String professionDuration1;
	private String localProfessionType2;
	private String localProfessionName2;
	private String technicalTitle2;
	private String professionDuration2;
	private String direction;
	private String identity;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPoliticalStatus() {
		return politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getIsGovernmentWorker() {
		return isGovernmentWorker;
	}

	public void setIsGovernmentWorker(String isGovernmentWorker) {
		this.isGovernmentWorker = isGovernmentWorker;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	public String getHouseholdPlace() {
		return householdPlace;
	}

	public void setHouseholdPlace(String householdPlace) {
		this.householdPlace = householdPlace;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMilitaryServiceStatus() {
		return militaryServiceStatus;
	}

	public void setMilitaryServiceStatus(String militaryServiceStatus) {
		this.militaryServiceStatus = militaryServiceStatus;
	}

	public String getIsStudentInCollege() {
		return isStudentInCollege;
	}

	public void setIsStudentInCollege(String isStudentInCollege) {
		this.isStudentInCollege = isStudentInCollege;
	}

	public String getEnlistmentTime() {
		return enlistmentTime;
	}

	public void setEnlistmentTime(String enlistmentTime) {
		this.enlistmentTime = enlistmentTime;
	}

	public String getRetireTime() {
		return retireTime;
	}

	public void setRetireTime(String retireTime) {
		this.retireTime = retireTime;
	}

	public String getTypeOfMilitary() {
		return typeOfMilitary;
	}

	public void setTypeOfMilitary(String typeOfMilitary) {
		this.typeOfMilitary = typeOfMilitary;
	}

	public String getMilitaryMajorName() {
		return militaryMajorName;
	}

	public void setMilitaryMajorName(String militaryMajorName) {
		this.militaryMajorName = militaryMajorName;
	}

	public String getMilitaryMajorDuration() {
		return militaryMajorDuration;
	}

	public void setMilitaryMajorDuration(String militaryMajorDuration) {
		this.militaryMajorDuration = militaryMajorDuration;
	}

	public String getPositionWhenRetire() {
		return positionWhenRetire;
	}

	public void setPositionWhenRetire(String positionWhenRetire) {
		this.positionWhenRetire = positionWhenRetire;
	}

	public String getMilitaryRankWhenRetire() {
		return militaryRankWhenRetire;
	}

	public void setMilitaryRankWhenRetire(String militaryRankWhenRetire) {
		this.militaryRankWhenRetire = militaryRankWhenRetire;
	}

	public String getLocalProfessionType1() {
		return localProfessionType1;
	}

	public void setLocalProfessionType1(String localProfessionType1) {
		this.localProfessionType1 = localProfessionType1;
	}

	public String getLocalProfessionName1() {
		return localProfessionName1;
	}

	public void setLocalProfessionName1(String localProfessionName1) {
		this.localProfessionName1 = localProfessionName1;
	}

	public String getTechnicalTitle1() {
		return technicalTitle1;
	}

	public void setTechnicalTitle1(String technicalTitle1) {
		this.technicalTitle1 = technicalTitle1;
	}

	public String getProfessionDuration1() {
		return professionDuration1;
	}

	public void setProfessionDuration1(String professionDuration1) {
		this.professionDuration1 = professionDuration1;
	}

	public String getLocalProfessionType2() {
		return localProfessionType2;
	}

	public void setLocalProfessionType2(String localProfessionType2) {
		this.localProfessionType2 = localProfessionType2;
	}

	public String getLocalProfessionName2() {
		return localProfessionName2;
	}

	public void setLocalProfessionName2(String localProfessionName2) {
		this.localProfessionName2 = localProfessionName2;
	}

	public String getTechnicalTitle2() {
		return technicalTitle2;
	}

	public void setTechnicalTitle2(String technicalTitle2) {
		this.technicalTitle2 = technicalTitle2;
	}

	public String getProfessionDuration2() {
		return professionDuration2;
	}

	public void setProfessionDuration2(String professionDuration2) {
		this.professionDuration2 = professionDuration2;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}


}
