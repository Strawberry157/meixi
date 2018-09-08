package com.huanke.iot.api.controller.meixi.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 描述:
 * 用户个人信息
 *
 * @author onlymark
 * @create 2018-09-08 上午10:31
 */
@Data
public class UserInfoRequest {
    private Integer sex;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date birthDate;
    private Integer skinType;
}
