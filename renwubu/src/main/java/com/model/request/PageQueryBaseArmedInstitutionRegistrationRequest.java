package com.model.request;


/**
 * @author wuyuxiao
 */

public class PageQueryBaseArmedInstitutionRegistrationRequest {
    private String searchKey;
    private String name;
    private String type;
    private String place;
    private String approvalBy;
    private String level;
    private String managementRelation;
    private String regionDistribution;
    private Integer pageNumber;
    private Integer pageSize;
    private  String identity;

    public String getSearchKey() {
        return searchKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRegionDistribution() {
        return regionDistribution;
    }

    public void setRegionDistribution(String regionDistribution) {
        this.regionDistribution = regionDistribution;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public Integer getPageNumber() {
        if (this.pageNumber == null) {
            return 1;
        }
        return this.pageNumber;
    }

    public Integer getPageSize() {
        if (this.pageSize == null) {
            return 10;
        }
        return this.pageSize;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}