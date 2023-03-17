package com.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.persistence.entity.CompanyPotentialRegistration;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author wuyuxiao
 */
@Mapper
public interface CompanyPotentialMapper extends BaseMapper<CompanyPotentialRegistration> {


    List<CompanyPotentialRegistration> pageQuery(@Param("searchKey") String searchKey,
                                                 @Param("identity") String identity,
                                                 @Param("offset") int offset, @Param("pageSize") int pageSize);

    int queryTotalCount(@Param("searchKey") String searchKey,
                        @Param("identity") String identity);

    List<CompanyPotentialRegistration> findByName(@Param("name") String name, @Param("identity") String identity);

}