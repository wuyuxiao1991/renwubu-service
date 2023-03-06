package com.service.visualizationhandler;

import com.model.dto.StatisticsDto;
import com.model.dto.ValueDto;
import com.persistence.mapper.MinbingLeaderRegistrationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.model.constants.enums.StatisticsTypeEnum.EDUCATION_LEVEL_OF_MINBING_LEADER;

/**
 * @author wuyuxiao
 */
@Service
public class MinbingLeaderVisualizeHandler implements VisualizeHandler {
    @Autowired
    private MinbingLeaderRegistrationMapper mapper;
    private final List<String> SUPPORT_VISUALIZATION_TYPES = Arrays.asList(EDUCATION_LEVEL_OF_MINBING_LEADER.name());
    private final Map<String, String> typeToGroupByField = new HashMap<String, String>() {
        {
            put(EDUCATION_LEVEL_OF_MINBING_LEADER.name(), "education_level");
        }
    };

    @Override
    public Boolean isSupport(String type) {
        return SUPPORT_VISUALIZATION_TYPES.contains(type);
    }

    @Override
    public List<StatisticsDto> calculate(String type, String identity) {
        String groupByField = typeToGroupByField.get(type);
        List<HashMap<String, String>> list = mapper.groupBy(groupByField, identity);
        return list.stream().map(p -> new StatisticsDto(p.get(groupByField), new ValueDto(Integer.valueOf(String.valueOf(p.get("count"))), null))).collect(Collectors.toList());
    }
}
