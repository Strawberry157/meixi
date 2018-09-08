package com.huanke.iot.base.po;

import com.huanke.iot.base.persistence.DataEntity;
import lombok.Data;


/**
 * 描述:
 * 用户授权类
 *
 * @author onlymark
 * @create 2018-09-07 下午2:19
 */
@Data
public class UserAuth extends DataEntity {

    /**
     * 用户基础表唯一标识
     */
    private Integer userId;

    /**
     * 身份类型
     */
    private Integer identityType;

    /**
     * 身份唯一标识（邮箱，手机号，第三方唯一标识）
     */
    private String identifier;

    /**
     * 授权凭证
     */
    private String credential;




}