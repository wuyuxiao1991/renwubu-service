package com.renwubu.model.constants.enums;

public enum IdentityEnum {
    QINGCUN("奉贤区青村镇"),
    JINSHA("奉贤区金沙镇"),
    FENGXIAN("奉贤区");

    private String name;

    IdentityEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}