package com.model.constants.enums;

import com.model.dto.StatisticsDto;

/**
 * @author wuyuxiao
 */

public enum StatisticsTypeEnum {
    /**
     *
     */
    PROFESSIONAL_TYPE_OF_TEAM_DETAIL("队伍详情表-按专业划分"),
    TOTAL_PEOPLE_COUNT_OF_TEAM_DETAIL("队伍详情表-按人数划分"),
    TEAM_MEMBER_COUNT_OF_TEAM_DETAIL("队伍详情表-按队伍统计人数"),
    POLITICAL_STATUS_OF_PEOPLE_DETAIL("人员详情表-按政治状态划分"),
    RETIRE_SOLDIER_OF_PEOPLE_DETAIL("人员详情表-按是否退役划分"),
    SEX_OF_PEOPLE_DETAIL("人员详情表-按性别划分"),
    NATIONALITY_OF_PEOPLE_DETAIL("人员详情表-按民族划分"),
    EDUCATION_LEVEL_OF_PEOPLE_DETAIL("人员详情表-按受教育成都划分"),
    EDUCATION_LEVEL_OF_MINBING_LEADER("民兵干部登记表-按受教育程度划分"),
    POSITION_OF_MINBING_LEADER("民兵干部登记表-按职位划分"),
    MILITARY_STATUS_OF_MINBING_LEADER("民兵干部登记表-按服兵役情况划分"),
    SEX_OF_MINBING_LEADER("民兵干部登记表-按性别划分"),
    TYPE_OF_ARMS_EQUIPMENT_REGISTRATION("武器装备登记表-按类型划分"),
    TYPE_OF_EMERGENCY_EQUIPMENT_REGISTRATION("应急装备登记表-按类型划分"),
    TYPE_OF_MILITARY_CIVILIZATION_EQUIPMENT("军民武器装备登记表-按类型划分"),
    TYPE_OF_TRAINING_MISSION_DETAILS("任务训练详情表-按组训方式统计人天数"),
    PLACE_OF_TRAINING_MISSION_DETAILS("任务训练详情表-按组训地点统计人天数"),
//    DAY_COUNT_OF_TRAINING_MISSION_DETAILS("任务训练详情表-按合计训练天数划分"),
    TEAM_OF_TRAINING_MISSION_DETAILS("任务训练详情表-按分队划分"),
    MAN_DAY_COUNT_OF_YEARLY_PLAN_DETAILS("年度计划详情表-各分队总人天数"),
    NAME_OF_PRE_BUILD_PARTY_ORGANIZATION("党组织预建表-按名称划分");

    private String name;

    StatisticsTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}