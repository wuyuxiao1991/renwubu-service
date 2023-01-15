package com.renwubu.endpoint;


import com.renwubu.model.BaseResponse;
import com.renwubu.model.dto.UserDto;
import com.renwubu.model.request.ValidateUserRequest;
import com.renwubu.persistence.entity.UserInfo;
import com.renwubu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wuyuxiao
 */
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/validate_user")
    BaseResponse<UserDto> validateUser(@RequestBody ValidateUserRequest request) {
        UserInfo result = userService.getUserInfoByName(request.getName());

        if (result == null) {
            return BaseResponse.failed("不存在该用户！");
        }

        if (!result.password.equals(request.password)) {
            return BaseResponse.failed("用户密码错误！");
        }

        return BaseResponse.ok(new UserDto(result.name, result.identity));
    }
}
