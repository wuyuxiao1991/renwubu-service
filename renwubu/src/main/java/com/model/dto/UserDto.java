package com.model.dto;

import com.persistence.entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;


/**
 * @author wuyuxiao
 */
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    String userGuid;
    String name;
    String identity;

    public String getUserGuid() {
        return userGuid;
    }


    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public static UserDto transform(UserInfo userInfo){
        UserDto  userDto=new UserDto();
        BeanUtils.copyProperties(userInfo,userDto);
        return userDto;
    }
}
