package com.huanke.iot.api.controller.meixi.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * 描述:
 * 用户登录request
 *
 * @author onlymark
 * @create 2018-09-07 下午10:12
 */
@Data
public class LoginUserRequest {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    @Size(min=6, max=16, message = "密码长度为6-16个字符")
    private String password;
}
