package com.model.dto;

import lombok.Data;


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

    public String getThirdMenuName() {
        return thirdMenuName;
    }

    public void setThirdMenuName(String thirdMenuName) {
        this.thirdMenuName = thirdMenuName;
    }

    public String getThirdMenuGuid() {
        return thirdMenuGuid;
    }

    public void setThirdMenuGuid(String thirdMenuGuid) {
        this.thirdMenuGuid = thirdMenuGuid;
    }

}