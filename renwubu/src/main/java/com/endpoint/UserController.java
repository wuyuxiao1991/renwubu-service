package com.endpoint;



import com.model.dto.UserDto;
import com.model.request.ValidateUserRequest;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.persistence.entity.UserInfo;
import com.model.BaseResponse;

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
