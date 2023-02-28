package com.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author wuyuxiao
 */
@Data
public class SecondMenuDto  {
    String secondMenuGuid;
    String secondMenuName;
    List<ThirdMenuDto> thirdMenuList;

    public SecondMenuDto() {
    }

    public SecondMenuDto(String secondMenuGuid, String secondMenuName, List<ThirdMenuDto> thirdMenuList) {
        this.secondMenuGuid = secondMenuGuid;
        this.secondMenuName = secondMenuName;
        this.thirdMenuList = thirdMenuList;
    }

    public void setSecondMenuGuid(String secondMenuGuid) {
        this.secondMenuGuid = secondMenuGuid;
    }

    public String getSecondMenuGuid() {
        return secondMenuGuid;
    }

    public String getSecondMenuName() {
        return secondMenuName;
    }

    public void setSecondMenuName(String secondMenuName) {
        this.secondMenuName = secondMenuName;
    }

    public List<ThirdMenuDto> getThirdMenuList() {
        return thirdMenuList;
    }

    public void setThirdMenuList(List<ThirdMenuDto> thirdMenuList) {
        this.thirdMenuList = thirdMenuList;
    }
}
