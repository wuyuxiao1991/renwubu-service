package com.model.request;

/**
 * @author KevinMite-Lyh
 */

public class AddMilitaryServiceRegistrationRequest {
    private String idNumber;
    private String name;
    private String sex;
    private String birthDate;
    private String householdPlace;
    private String workPlace;
    private String receiptConfirmation;
    private String status;
    private String identity;

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getHouseholdPlace() {
        return householdPlace;
    }

    public void setHouseholdPlace(String householdPlace) {
        this.householdPlace = householdPlace;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getReceiptConfirmation() {
        return receiptConfirmation;
    }

    public void setReceiptConfirmation(String receiptConfirmation) {
        this.receiptConfirmation = receiptConfirmation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

}
