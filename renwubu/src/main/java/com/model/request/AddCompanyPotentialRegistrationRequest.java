package com.model.request;

import lombok.Data;

/**
 * @author wuyuxiao
 */
@Data
public class AddCompanyPotentialRegistrationRequest {

    public String name;

    public String uniqueCode;

    public String workPlace;

    public String workDetailedAddress;

    public String contactPerson;

    public String contactMethod;

    public String property;

    public String industry;

    public String partyOrganizationBuilding;

    public String business;

    public String maleEmployeeNumber;

    public String femaleEmployeeNumber;

    public String majorBusiness;

    public String equipmentName;

    public String equipmentMajorProperty;

    public String equipmentNumber;

    public String professionalDirection;

    public String professionalPeopleCount;

    public String hasBusinessArmedForce;

    public String identity;
}
