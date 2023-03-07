package com.model.request;

/**
 * @author KevinMite-Lyh
 */

public class AddBaseArmedInstitutionRegistrationRequest {
    private String name;
    private String type;
    private String place;
    private String approvalBy;
    private String managementRelation;
    private String level;
    private String regionDistribution;
    private String memo;
    private String identity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getApprovalBy() {
        return approvalBy;
    }

    public void setApprovalBy(String approvalBy) {
        this.approvalBy = approvalBy;
    }

    public String getManagementRelation() {
        return managementRelation;
    }

    public void setManagementRelation(String managementRelation) {
        this.managementRelation = managementRelation;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRegionDistribution() {
        return regionDistribution;
    }

    public void setRegionDistribution(String regionDistribution) {
        this.regionDistribution = regionDistribution;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }


}
