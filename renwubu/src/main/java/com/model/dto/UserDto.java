package com.model.dto;

import com.persistence.entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;


/**
 * @author wuyuxiao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    String userGuid;
    String name;
    String identity;


    public static UserDto transfrom(UserInfo userInfo){
        UserDto  userDto=new UserDto();
        BeanUtils.copyProperties(userInfo,userDto);
        return userDto;
    }
}
