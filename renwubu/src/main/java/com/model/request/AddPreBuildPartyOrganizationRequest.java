package com.model.request;

/**
 * @author KevinMite-Lyh
 */

public class AddPreBuildPartyOrganizationRequest{
    private String partyOrganizationName;
    private String partyOrganizationStartTime;
    private String approvalBy;

    private String subordination;
    private String team;
    private String identity;
    private boolean deleted;

    public String getPartyOrganizationName() {
        return partyOrganizationName;
    }

    public void setPartyOrganizationName(String partyOrganizationName) {
        this.partyOrganizationName = partyOrganizationName;
    }

    public String getPartyOrganizationStartTime() {
        return partyOrganizationStartTime;
    }

    public void setPartyOrganizationStartTime(String partyOrganizationStartTime) {
        this.partyOrganizationStartTime = partyOrganizationStartTime;
    }

    public String getApprovalBy() {
        return approvalBy;
    }

    public void setApprovalBy(String approvalBy) {
        this.approvalBy = approvalBy;
    }

    public String getSubordination() {
        return subordination;
    }

    public void setSubordination(String subordination) {
        this.subordination = subordination;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
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
