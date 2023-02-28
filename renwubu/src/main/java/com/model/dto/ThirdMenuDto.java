package com.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wuyuxiao
 */
@Data
public class ThirdMenuDto  {
    String thirdMenuGuid;
    String thirdMenuName;

    public ThirdMenuDto(String thirdMenuGuid, String thirdMenuName) {
        this.thirdMenuGuid = thirdMenuGuid;
        this.thirdMenuName = thirdMenuName;
    }

}