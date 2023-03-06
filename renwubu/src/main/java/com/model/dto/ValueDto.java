package com.model.dto;

import lombok.AllArgsConstructor;

/**
 * @author wuyuxiao
 */

public class ValueDto {
    Integer number;
    String memo;

    public ValueDto(Integer number,String memo){
        this.number=number;
        this.memo=memo;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}


