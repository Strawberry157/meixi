package com.huanke.iot.api.controller.meixi.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * 描述:
 * 手机注册发送验证码
 *
 * @author onlymark
 * @create 2018-09-07 下午9:23
 */
@Data
public class SendCodeRequest {
    @Pattern(regexp = "1\\d{10}")
    @NotBlank(message = "手机号码不能为空")
    private String mobile;

}
