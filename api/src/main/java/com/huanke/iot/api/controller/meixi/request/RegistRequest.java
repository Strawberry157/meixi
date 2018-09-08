package com.huanke.iot.api.controller.meixi.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 描述:
 * 注册请求
 *
 * @author onlymark
 * @create 2018-09-07 下午5:09
 */
@Data
public class RegistRequest {
    @Pattern(regexp = "1\\d{10}",message = "手机号码格式不正确")
    @NotBlank(message = "手机号码不能为空")
    private String mobile;
    @NotNull(message = "密码不能为空")
    @Size(min=6, max=16, message = "密码长度为6-16个字符")
    private String password;
    @NotNull(message = "验证码不能为空")
    private String smsCode;
}
