package com.model.request;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author wuyuxiao
 */
@Data
public class AddEquipmentPotentialRegistrationRequest {

    public String name;

    public String majorProperty;

    public String number;

    public String technicalStatus;

    public String storagePlace;

    public String keepOrganization;

    public String contactPerson;

    public String contactMethod;

    public String identity;
}
