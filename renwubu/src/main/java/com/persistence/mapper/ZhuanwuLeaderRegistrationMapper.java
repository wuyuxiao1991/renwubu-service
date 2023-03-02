package com.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.persistence.entity.ZhuanwuLeaderRegistration;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author wuyuxiao
 */
@Mapper
public interface ZhuanwuLeaderRegistrationMapper extends BaseMapper<ZhuanwuLeaderRegistration> {


    int queryTotalCount(@Param("searchKey") String searchKey,
                        @Param("name") String name,
                        @Param("position") String position,
                        @Param("politicalStatus") String politicalStatus,
                        @Param("educationLevel") String educationLevel,
                        @Param("phone") String phone,
                        @Param("identity") String identity);


    List<ZhuanwuLeaderRegistration> pageQuery(@Param("searchKey") String searchKey,
                                              @Param("name") String name,
                                              @Param("position") String position,
                                              @Param("politicalStatus") String politicalStatus,
                                              @Param("educationLevel") String educationLevel,
                                              @Param("phone") String phone,
                                              @Param("identity") String identity,
                                              @Param("offset") int offset, @Param("pageSize") int pageSize);


    int updateDeleteStatus(String id);
    List<ZhuanwuLeaderRegistration> findWorkAndNameAndIdNumberAndPhoneAndIdentity(
                                                                                  @Param("idNumber")String idNumber,
                                                                                  @Param("identity") String identity
                                                                                  );
}