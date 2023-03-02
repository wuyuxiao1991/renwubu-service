package com.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.persistence.entity.MilitaryServiceRegistration;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author wuyuxiao
 */
@Mapper
public interface MilitaryServiceRegistrationMapper extends BaseMapper<MilitaryServiceRegistration> {


    List<MilitaryServiceRegistration> pageQuery(@Param("searchKey") String searchKey,
                                                @Param("name") String name,
                                                @Param("idCard") String idCard,
                                                @Param("identity") String identity,
                                                @Param("offset") int offset, @Param("pageSize") int pageSize);

    int queryTotalCount(@Param("searchKey") String searchKey,
                        @Param("name") String name,
                        @Param("idCard") String idCard,
                        @Param("identity") String identity);

    int updateDeleteStatus(String id);
    List<MilitaryServiceRegistration> findIdNumber(@Param("idNumber")String idNumber,
                                                   @Param("identity")String identity);
}