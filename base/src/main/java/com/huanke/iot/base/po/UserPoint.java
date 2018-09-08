package com.huanke.iot.base.po;

import com.huanke.iot.base.persistence.DataEntity;
import lombok.Data;

/**
 * 描述:
 * 用户积分表
 *
 * @author onlymark
 * @create 2018-09-07 下午4:06
 */
@Data
public class UserPoint extends DataEntity {

    /**
     * 用户唯一标识
     */
    private Integer userId;

    private Integer points;

    /**
     * 增长倍数（冗余）
     */
    private Double incrMulti;
}
