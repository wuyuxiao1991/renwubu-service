package com.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.persistence.entity.ArmsEquipmentRegistration;
import com.persistence.entity.EmergencyEquipmentRegistration;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;


/**
 * @author wuyuxiao
 */
@Mapper
public interface EmergencyEquipmentRegistrationMapper extends BaseMapper<ArmsEquipmentRegistration> {


    List<EmergencyEquipmentRegistration> pageQuery(@Param("searchKey") String searchKey,
                                                   @Param("equipmentPerformance") String equipmentPerformance,
                                                   @Param("identity") String identity,
                                                   @Param("offset") int offset, @Param("pageSize") int pageSize);

    int queryTotalCount(@Param("searchKey") String searchKey,
                        @Param("equipmentPerformance") String equipmentPerformance,
                        @Param("identity") String identity);

    int updateDeleteStatus(String id);

    List<HashMap<String,String>> groupBy(@Param("groupByField") String groupByField, @Param("identity") String identity);

}