package com.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.persistence.entity.ArmsEquipmentRegistration;
import com.persistence.entity.MilitaryAndCivilianEquipmentRegistration;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;


/**
 * @author wuyuxiao
 */
@Mapper
public interface MilitaryCivilizationEquipmentMapper extends BaseMapper<MilitaryAndCivilianEquipmentRegistration> {


    List<MilitaryAndCivilianEquipmentRegistration> pageQuery(@Param("searchKey") String searchKey,
                                           @Param("organizationType") String organizationType,
                                           @Param("identity") String identity,
                                           @Param("offset") int offset, @Param("pageSize") int pageSize);

    int queryTotalCount(@Param("searchKey") String searchKey,
                        @Param("organizationType") String organizationType,
                        @Param("identity") String identity);

    int updateDeleteStatus(String id);


    List<HashMap<String,String>> groupBy(@Param("groupByField") String groupByField, @Param("identity") String identity);

}