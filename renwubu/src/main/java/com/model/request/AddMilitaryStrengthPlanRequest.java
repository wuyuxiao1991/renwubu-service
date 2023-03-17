package com.model.request;

import lombok.Data;

/**
 * @author KevinMite-Lyh
 */
@Data
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


}
