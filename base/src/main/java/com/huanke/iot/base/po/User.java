package com.huanke.iot.base.po;

import com.huanke.iot.base.persistence.DataEntity;
import lombok.Data;

import java.util.Date;

/**
 * 描述:
 * 用户信息类
 *
 * @author onlymark
 * @create 2018-09-07 下午2:19
 */
@Data
public class User extends DataEntity {

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 头像图片
     */
    private String headImg;

    /**
     * 背景图片
     */
    private String bgImg;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 身份等级
     */
    private Integer levelType;

    /**
     * 皮肤类型
     */
    private Integer skinType;

    /**
     * 出生日期
     */
    private Date birthDate;

    /**
     * 最后登陆时间
     */
    private Date lastLoginTime;

    /**
     * 最后登陆时间
     */
    private String lastLoginIp;

    /**
     * 是否初始化信息
     */
    private Integer isInit;

}
