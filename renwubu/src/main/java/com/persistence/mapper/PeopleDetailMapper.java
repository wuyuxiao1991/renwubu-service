package com.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.persistence.entity.PeopleDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author wuyuxiao
 */
@Mapper
public interface PeopleDetailMapper extends BaseMapper<PeopleDetail> {


    List<PeopleDetail> pageQuery(@Param("searchKey") String searchKey,
                               @Param("name") String name,
                               @Param("idCard") String idCard,
                               @Param("phone") String phone,
                               @Param("identity") String identity,
                               @Param("offset") int offset, @Param("pageSize") int pageSize);

    int queryTotalCount(@Param("searchKey") String searchKey,
                        @Param("name") String name,
                        @Param("idCard") String idCard,
                        @Param("phone") String phone,
                        @Param("identity") String identity);

// @Param的作用就是给参数命名从而在Mapper中可以被调用。这里获取到id_Number参数给这个参数命名为idCard
    List<PeopleDetail> findByIdCardAndIdentity(@Param("idCard") String idNumber, @Param("identity") String identity);

    int updateDeleteStatus(String id);

}