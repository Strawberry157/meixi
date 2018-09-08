package com.huanke.iot.base.po;

import com.huanke.iot.base.persistence.DataEntity;
import lombok.Data;

import java.util.Date;

/**
 * 描述:
 * 管理员
 *
 * @author onlymark
 * @create 2018-09-07 下午3:36
 */
@Data
public class Admin extends DataEntity {

    private String nickname;

    private String password;

    private Date lastLoginTime;

    private String lastLoginIp;


}
