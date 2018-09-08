package com.huanke.iot.base.po;

import com.huanke.iot.base.persistence.DataEntity;
import lombok.Data;

/**
 * 描述:
 * 问题类
 *
 * @author onlymark
 * @create 2018-09-07 下午3:49
 */
@Data
public class Question extends DataEntity {

    /**
     * 问题标题（20）
     */
    private String title;

    private String answer;

    /**
     * 排序
     */
    private Integer sort;
}