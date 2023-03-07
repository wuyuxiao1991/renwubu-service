package com.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.persistence.entity.ArmsEquipmentRegistration;
import com.persistence.entity.BaseArmedInstitutionRegistration;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author wuyuxiao
 */
@Mapper
public interface ArmsEquipmentRegistrationMapper extends BaseMapper<ArmsEquipmentRegistration> {


    List<ArmsEquipmentRegistration> pageQuery(@Param("searchKey") String searchKey,
                                              @Param("equipmentName") String equipmentName,
                                              @Param("identity") String identity,
                                              @Param("offset") int offset, @Param("pageSize") int pageSize);

    int queryTotalCount(@Param("searchKey") String searchKey,
                        @Param("equipmentName") String equipmentName,
                        @Param("identity") String identity);

    int updateDeleteStatus(String id);

    List<HashMap<String,String>> groupBy(@Param("groupByField") String groupByField, @Param("identity") String identity);

    List<ArmsEquipmentRegistration> findEquipmentNameAndType(@Param("equipmentName")String equipmentName,
                                                             @Param("type")String type,
                                                             @Param("identity")String identity);


}