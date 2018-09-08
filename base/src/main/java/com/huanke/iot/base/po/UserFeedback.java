package com.huanke.iot.base.po;

import com.huanke.iot.base.persistence.DataEntity;
import lombok.Data;

/**
 * 描述:
 * 用户反馈类
 *
 * @author onlymark
 * @create 2018-09-07 下午3:58
 */
@Data
public class UserFeedback extends DataEntity {

    private Integer userId;

    /**
     * 反馈内容（100）
     */
    private String content;
}
