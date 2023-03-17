package com.model.request;

import lombok.Data;

/**
 * @author wuyuxiao
 */
@Data
public class AddPeoplePotentialRegistrationRequest {
    private String name;
    private String idNumber;
    private String age;
    private String sex;
    private String politicalStatus;
    public String joinPartyTime;
    public String educationLevel;
    public String nationality;
    public String health;
    public String work;
    public String workProperty;
    public String position;
    public String isPartyWorker;
    public String workPlace;
    public String householdPlace;
    public String phone;
    public String militaryStatus;
    public String isCollegeStudent;
    public String enlistmentTime;
    public String retireTime;
    public String militaryServiceType;
    public String militaryMajorName;
    public String militaryMajorDuration;
    public String positionWhenRetire;
    public String rankWhenRetire;
    public String localMajorName1;
    public String technicalTitle1;
    public String localMajorDuration1;
    public String localMajorName2;
    public String technicalTitle2;
    public String localMajorDuration2;
    public String identity;
}
