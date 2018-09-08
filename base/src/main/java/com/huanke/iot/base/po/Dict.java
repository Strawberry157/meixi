package com.huanke.iot.base.po;

import com.huanke.iot.base.persistence.DataEntity;
import lombok.Data;

/**
 * 描述:
 * 字典类
 *
 * @author onlymark
 * @create 2018-09-07 下午3:20
 */
@Data
public class Dict extends DataEntity {

    /**
     * 字典值
     */
    private Integer value;

    /**
     * 标签
     */
    private String label;

    /**
     * 字典类型
     */
    private String type;

    private String description;

    private Integer sort;

    private String remark;

    private Integer operationAdminId;


}
