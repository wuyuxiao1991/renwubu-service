package com.model.request;

/**
 * @author KevinMite-Lyh
 */

public class AddMilitaryStrengthPlanRequest {
    private String planName;
    private String executeTaskRegion;
    private String type;
    private String siteOrganizer;
    private String relatedGuarantee;
    private String staffSize;
    private String equipmentSize;
    private String district;
    private String identity;
    private boolean deleted;

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getExecuteTaskRegion() {
        return executeTaskRegion;
    }

    public void setExecuteTaskRegion(String executeTaskRegion) {
        this.executeTaskRegion = executeTaskRegion;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSiteOrganizer() {
        return siteOrganizer;
    }

    public void setSiteOrganizer(String siteOrganizer) {
        this.siteOrganizer = siteOrganizer;
    }

    public String getRelatedGuarantee() {
        return relatedGuarantee;
    }

    public void setRelatedGuarantee(String relatedGuarantee) {
        this.relatedGuarantee = relatedGuarantee;
    }

    public String getStaffSize() {
        return staffSize;
    }

    public void setStaffSize(String staffSize) {
        this.staffSize = staffSize;
    }

    public String getEquipmentSize() {
        return equipmentSize;
    }

    public void setEquipmentSize(String equipmentSize) {
        this.equipmentSize = equipmentSize;
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
