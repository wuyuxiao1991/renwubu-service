package com.service.visualizationhandler;

import com.model.dto.StatisticsDto;
import com.model.dto.ValueDto;
import com.persistence.mapper.TrainingMissionDetailMapper;
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
public class TrainingMissionDetailsVisualizeHandler implements VisualizeHandler {
    @Autowired
    private TrainingMissionDetailMapper mapper;
    private final List<String> SUPPORT_VISUALIZATION_TYPES = Arrays.asList(TYPE_OF_TRAINING_MISSION_DETAILS.name(), PLACE_OF_TRAINING_MISSION_DETAILS.name(), DAY_COUNT_OF_TRAINING_MISSION_DETAILS.name());
    private final Map<String, String> typeToGroupByField = new HashMap<String, String>() {
        {
            put(PLACE_OF_TRAINING_MISSION_DETAILS.name(), "concentrated_training_place");
            put(DAY_COUNT_OF_TRAINING_MISSION_DETAILS.name(), "total_count");
        }
    };

    @Override
    public Boolean isSupport(String type) {
        return SUPPORT_VISUALIZATION_TYPES.contains(type);
    }

    @Override
    public List<StatisticsDto> calculate(String type, String identity) throws Exception {
        String groupByField = typeToGroupByField.get(type);
        List<HashMap<String, String>> list;

        switch (type) {
            case "PLACE_OF_TRAINING_MISSION_DETAILS":
                list = mapper.groupByPlace(identity);
                return list.stream().map(p -> new StatisticsDto(p.get(groupByField), new ValueDto(Integer.valueOf(String.valueOf(p.get("sum"))), null))).collect(Collectors.toList());
            case "DAY_COUNT_OF_TRAINING_MISSION_DETAILS":
                list = mapper.groupByTotalDayCount(identity);
                return list.stream().map(p -> new StatisticsDto(p.get(groupByField), new ValueDto(Integer.valueOf(String.valueOf(p.get("count"))), null))).collect(Collectors.toList());
            default:
                throw new Exception("输入错误");
        }

    }
}
