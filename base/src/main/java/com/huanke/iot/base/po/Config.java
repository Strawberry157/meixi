package com.huanke.iot.base.po;

import com.huanke.iot.base.persistence.DataEntity;
import lombok.Data;

/**
 * 描述:
 * 配置类
 *
 * @author onlymark
 * @create 2018-09-07 下午3:31
 */
@Data
public class Config extends DataEntity {

    /**
     * 名称（唯一）
     */
    private String name;

    /**
     * 值
     */
    private String value;

    /**
     * 备注
     */
    private String remark;

}
