package com.huanke.iot.api.controller.meixi.vo;

import lombok.Data;

/**
 * 描述:
 *
 * @author onlymark
 * @create 2018-09-08 下午3:47
 */
@Data
public class UserInfoVo {
    private String nickname;
    private String headImg;
    private String bgImg;
    private Integer points;
    private Double incrMulti;
    private Integer isInit;
}
