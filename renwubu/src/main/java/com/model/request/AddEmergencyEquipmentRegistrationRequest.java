package com.model.request;

import lombok.Data;

/**
 * @author KevinMite-Lyh
 */
@Data
public class AddEmergencyEquipmentRegistrationRequest {
    private String equipmentName;
    private String type;
    private String unit;
    private String number;
    private String purpose;
    private String warehousingTime;
    private String equipmentPerformance;
    private String storagePlace;
    private String managementUnit;
    private String dispatchTime;
    private String organizationType;
    private String district;
    private String identity;


}
