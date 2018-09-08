package com.huanke.iot.base.po;

import com.huanke.iot.base.persistence.DataEntity;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 描述:
 * 用户能力日志类
 *
 * @author onlymark
 * @create 2018-09-07 下午3:52
 */
@Data
public class UserAbilityLog extends DataEntity {

    private Integer userId;

    private Integer type;

    private Double currValue;

    private Double sumValue;
}
