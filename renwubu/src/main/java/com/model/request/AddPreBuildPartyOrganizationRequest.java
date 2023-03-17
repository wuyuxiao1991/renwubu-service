package com.model.request;

import lombok.Data;

/**
 * @author KevinMite-Lyh
 */

@Data
public class AddPreBuildPartyOrganizationRequest{
    private String partyOrganizationName;
    private String partyOrganizationStartTime;
    private String approvalBy;
    private String subordination;
    private String team;
    private String identity;

}
