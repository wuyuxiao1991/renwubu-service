package com.model.request;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author wuyuxiao
 */

@Data
public class AddTeamDetailRequest {
    private String name;

    private String type;

    private String task;

    private String professionalType;

    private String numberOfPeople;

    private Date formationTime;

    private String identity;

}

