package com.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.persistence.entity.EquipmentPotentialRegistration;
import com.persistence.entity.TeamDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;


/**
 * @author wuyuxiao
 */
@Mapper
public interface EquipmentPotentialMapper extends BaseMapper<EquipmentPotentialRegistration> {


    List<EquipmentPotentialRegistration> pageQuery(@Param("searchKey") String searchKey,
                                                   @Param("identity") String identity,
                                                   @Param("offset") int offset, @Param("pageSize") int pageSize);

    int queryTotalCount(@Param("searchKey") String searchKey,
                        @Param("identity") String identity);

}