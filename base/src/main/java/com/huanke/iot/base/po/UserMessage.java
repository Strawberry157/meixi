package com.huanke.iot.base.po;

import com.huanke.iot.base.persistence.DataEntity;
import lombok.Data;

/**
 * 描述:
 * 用户消息关系表
 *
 * @author onlymark
 * @create 2018-09-07 下午4:03
 */
@Data
public class UserMessage extends DataEntity {

    private Integer userId;

    private Integer messageId;
}
