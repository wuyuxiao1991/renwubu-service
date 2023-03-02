package com.model.request;

/**
 * @author KevinMite-Lyh
 */

public class AddMilitaryStrengthGuaranteeRequest {
    private String registrationTask;

    private String registrationPerson;
    private String funds;
    private String equipment;
    private String memo;
    private String district;
    private String identity;
    private boolean deleted;

    public String getRegistrationTask() {
        return registrationTask;
    }

    public void setRegistrationTask(String registrationTask) {
        this.registrationTask = registrationTask;
    }

    public String getRegistrationPerson() {
        return registrationPerson;
    }

    public void setRegistrationPerson(String registrationPerson) {
        this.registrationPerson = registrationPerson;
    }

    public String getFunds() {
        return funds;
    }

    public void setFunds(String funds) {
        this.funds = funds;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
