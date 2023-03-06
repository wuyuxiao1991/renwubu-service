package com.service.visualizationhandler;

import com.model.dto.StatisticsDto;
import com.model.dto.ValueDto;
import com.persistence.mapper.YearlyPlanDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.model.constants.enums.StatisticsTypeEnum.MAN_DAY_COUNT_OF_YEARLY_PLAN_DETAILS;

/**
 * @author wuyuxiao
 */
@Service
public class YearlyPlanDetailsVisualizeHandler implements VisualizeHandler {
    @Autowired
    private YearlyPlanDetailsMapper mapper;
    private final List<String> SUPPORT_VISUALIZATION_TYPES = Arrays.asList(MAN_DAY_COUNT_OF_YEARLY_PLAN_DETAILS.name());
    private final Map<String, String> typeToGroupByField = new HashMap<String, String>() {
        {
            put(MAN_DAY_COUNT_OF_YEARLY_PLAN_DETAILS.name(), "team_branch");
        }
    };

    @Override
    public Boolean isSupport(String type) {
        return SUPPORT_VISUALIZATION_TYPES.contains(type);
    }

    @Override
    public List<StatisticsDto> calculate(String type, String identity) throws Exception {
        String groupByField = typeToGroupByField.get(type);
        List<HashMap<String, String>> list = mapper.groupBy(identity);
        return list.stream().map(p -> new StatisticsDto(p.get(groupByField), new ValueDto(Integer.valueOf(String.valueOf(p.get("sum"))), null))).collect(Collectors.toList());

    }

}

