package com.service.visualizationhandler;

import com.model.dto.StatisticsDto;
import com.model.dto.ValueDto;
import com.persistence.mapper.EmergencyEquipmentRegistrationMapper;
import com.persistence.mapper.PreBuildPartyOrganizationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.model.constants.enums.StatisticsTypeEnum.NAME_OF_PRE_BUILD_PARTY_ORGANIZATION;
import static com.model.constants.enums.StatisticsTypeEnum.TYPE_OF_EMERGENCY_EQUIPMENT_REGISTRATION;

/**
 * @author wuyuxiao
 */
@Service
public class PreBuildPartyOrganizationVisualizeHandler implements VisualizeHandler {
    @Autowired
    private PreBuildPartyOrganizationMapper mapper;
    private final List<String> SUPPORT_VISUALIZATION_TYPES = Arrays.asList(NAME_OF_PRE_BUILD_PARTY_ORGANIZATION.name());

    private final Map<String, String> typeToGroupByField = new HashMap<String, String>() {
        {
            put(NAME_OF_PRE_BUILD_PARTY_ORGANIZATION.name(), "party_organization_name");
        }
    };

    @Override
    public Boolean isSupport(String type) {
        return SUPPORT_VISUALIZATION_TYPES.contains(type);
    }

    @Override
    public List<StatisticsDto> calculate(String type, String identity) {
        List<HashMap<String,String>> list = mapper.groupBy(identity);
        return list.stream().map(p->new StatisticsDto(p.get("truncated_name"),new ValueDto(Integer.valueOf(String.valueOf(p.get("count"))),null))).collect(Collectors.toList());
    }
}
