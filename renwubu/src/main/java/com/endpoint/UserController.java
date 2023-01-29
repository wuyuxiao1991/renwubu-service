package com.endpoint;


import com.model.BaseResponse;
import com.model.dto.UserDto;
import com.model.request.ValidateUserRequest;
import com.persistence.entity.UserInfo;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        try {
            UserInfo result = userService.getUserInfoByName(request.getName());

            if (result == null) {
                return BaseResponse.failed("不存在该用户！");
            }

            if (!result.password.equals(request.password)) {
                return BaseResponse.failed("用户密码错误！");
            }

            return BaseResponse.ok(UserDto.transform(result));
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }
}
