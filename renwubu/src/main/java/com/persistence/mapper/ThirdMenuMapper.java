package com.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.persistence.entity.SecondMenu;
import com.persistence.entity.ThirdMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wuyuxiao
 */
@Mapper
public interface ThirdMenuMapper extends BaseMapper<ThirdMenu> {

    List<ThirdMenu> findBySecondMenuGuid(String secondMenuGuid);

    ThirdMenu findByGuid(String thirdMenuGuid);


}