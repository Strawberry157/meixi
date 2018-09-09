package com.huanke.iot.base.po;

import com.huanke.iot.base.persistence.DataEntity;
import lombok.Data;

import java.util.Date;

/**
 * 描述:
 * 用户保养时间记录
 *
 * @author onlymark
 * @create 2018-09-09 上午11:16
 */
@Data
public class UserFaceTime extends DataEntity {
    private Integer userId;

    private Date faceTime;
}
