package com.model.dto;

/**
 * @author wuyuxiao
 */

public class StatisticsDto {
    String key;
    ValueDto value;

    public StatisticsDto(String key, ValueDto value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ValueDto getValue() {
        return value;
    }

    public void setValue(ValueDto value) {
        this.value = value;
    }
}


