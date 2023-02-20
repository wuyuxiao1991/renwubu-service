package com.model.request;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author wuyuxiao
 */

public class AddTeamDetailRequest {
    private String name;

    private String type;

    private String task;

    private String professionalType;

    private String numberOfPeople;

    private Date formationTime;

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

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Date getFormationTime() {
        return formationTime;
    }

    public void setFormationTime(Date formationTime) {
        this.formationTime = formationTime;
    }

    public String getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(String numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getProfessionalType() {
        return professionalType;
    }

    public void setProfessionalType(String professionalType) {
        this.professionalType = professionalType;
    }
}

