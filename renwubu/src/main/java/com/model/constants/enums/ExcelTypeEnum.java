package com.model.constants.enums;

/**
 * @author wuyuxiao
 */

public enum ExcelTypeEnum {
    /**
     *
     */
    PEOPLE_DETAIL("人员详情表"),
    TRAINING_MISSION_DETAILS("训练任务详情表"),
    YEARLY_PLAN_DETAILS("年度计划详情表"),
    ARMS_EQUIPMENT_REGISTRATION("武器装备登记表"),
    MILITARY_STRENGTH_REGISTRATION("兵力动用登记表"),
    MINBING_LEADER_REGISTRATION("民兵干部登记表"),
    ZHUANWU_LEADER_REGISTRATION("专武干部登记表"),
    BASE_ARMED_INSTITUTION_REGISTRATION("基层武装机构登记表"),
    EMERGENCY_EQUIPMENT_REGISTRATION("应急装备登记表"),
    MILITARY_AND_CIVILIZATION_EQUIPMENT_REGISTRATION("军民通用装备登记表"),
    MILITARY_SERVICE_REGISTRATION("兵役登记表"),
    PRE_BUILD_PARTY_ORGANIZATION("预备党组织登记表"),
    PEOPLE_POTENTIAL("人员潜力表"),
    COMPANY_POTENTIAL("人员潜力表"),
    EQUIPMENT_POTENTIAL("人员潜力表")
    ;

    private String name;

    ExcelTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    }