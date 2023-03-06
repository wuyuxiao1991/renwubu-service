package com.service.visualizationhandler;

import com.model.dto.StatisticsDto;
import com.model.dto.ValueDto;
import com.persistence.mapper.TeamDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.model.constants.enums.StatisticsTypeEnum.*;

/**
 * @author wuyuxiao
 */
@Service
public class TeamDetailVisualizeHandler implements VisualizeHandler {
    @Autowired
    private TeamDetailMapper mapper;
    private final List<String> SUPPORT_VISUALIZATION_TYPES = Arrays.asList(PROFESSIONAL_TYPE_OF_TEAM_DETAIL.name(), TOTAL_PEOPLE_COUNT_OF_TEAM_DETAIL.name(),
            TEAM_MEMBER_COUNT_OF_TEAM_DETAIL.name());
    private final Map<String, String> typeToGroupByField = new HashMap<String, String>() {
        {
            put(PROFESSIONAL_TYPE_OF_TEAM_DETAIL.name(), "professional_type");
            put(TOTAL_PEOPLE_COUNT_OF_TEAM_DETAIL.name(), "number_of_people");
            put(TEAM_MEMBER_COUNT_OF_TEAM_DETAIL.name(), "name");
        }
    };

    @Override
    public Boolean isSupport(String type) {
        return SUPPORT_VISUALIZATION_TYPES.contains(type);
    }

    @Override
    public List<StatisticsDto> calculate(String type, String identity) throws Exception {
        String groupByField = typeToGroupByField.get(type);
        List<HashMap<String, String>> list ;

        switch (type) {
            case "PROFESSIONAL_TYPE_OF_TEAM_DETAIL":
            case "TOTAL_PEOPLE_COUNT_OF_TEAM_DETAIL":
                list = mapper.groupBy(groupByField, identity);
                return list.stream().map(p -> new StatisticsDto(p.get(groupByField), new ValueDto(Integer.valueOf(String.valueOf(p.get("count"))), null))).collect(Collectors.toList());
            case "TEAM_MEMBER_COUNT_OF_TEAM_DETAIL":
                list = mapper.groupByTeam( identity);
                return list.stream().map(p -> new StatisticsDto(p.get(groupByField), new ValueDto(Integer.valueOf(String.valueOf(p.get("sum"))), null))).collect(Collectors.toList());
            default:
               throw new Exception("输入错误");
        }

    }
}
