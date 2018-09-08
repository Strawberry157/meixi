package com.huanke.iot.base.po;

import com.huanke.iot.base.persistence.DataEntity;
import lombok.Data;

/**
 * 描述:
 * 消息类
 *
 * @author onlymark
 * @create 2018-09-07 下午3:40
 */
@Data
public class Message extends DataEntity {

    /**
     * 消息类型（保留字段）
     */
    private Integer type;

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 标题图片
     */
    private String titleImg;

    /**
     * 是否认证通过
     */
    private Integer isVerify;

}
