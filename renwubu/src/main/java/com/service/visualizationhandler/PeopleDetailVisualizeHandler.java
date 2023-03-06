package com.service.visualizationhandler;

import com.model.dto.StatisticsDto;
import com.model.dto.ValueDto;
import com.persistence.mapper.PeopleDetailMapper;
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
public class PeopleDetailVisualizeHandler implements VisualizeHandler{
    @Autowired
    private PeopleDetailMapper mapper;
    private final List<String> SUPPORT_VISUALIZATION_TYPES = Arrays.asList(POLITICAL_STATUS_OF_PEOPLE_DETAIL.name(), RETIRE_SOLDIER_OF_PEOPLE_DETAIL.name(),
            SEX_OF_PEOPLE_DETAIL.name(), NATIONALITY_OF_PEOPLE_DETAIL.name(), EDUCATION_LEVEL_OF_PEOPLE_DETAIL.name());

    private final Map<String, String> typeToGroupByField = new HashMap<String, String>() {
        {
            put(POLITICAL_STATUS_OF_PEOPLE_DETAIL.name(), "political_status");
            put(RETIRE_SOLDIER_OF_PEOPLE_DETAIL.name(), "military_service_status");
            put(SEX_OF_PEOPLE_DETAIL.name(), "sex");
            put(NATIONALITY_OF_PEOPLE_DETAIL.name(), "nationality");
            put(EDUCATION_LEVEL_OF_PEOPLE_DETAIL.name(), "education_level");
        }
    };

    @Override
    public Boolean isSupport(String type) {
        return SUPPORT_VISUALIZATION_TYPES.contains(type);
    }

    @Override
    public List<StatisticsDto> calculate(String type, String identity) {
        String groupByField= typeToGroupByField.get(type);
        List<HashMap<String,String>> list = mapper.groupBy(groupByField, identity);
        return list.stream().map(p->new StatisticsDto(p.get(groupByField),new ValueDto(Integer.valueOf(String.valueOf(p.get("count"))),null))).collect(Collectors.toList());
    }
}
