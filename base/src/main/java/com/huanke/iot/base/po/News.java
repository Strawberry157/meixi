package com.huanke.iot.base.po;

import com.huanke.iot.base.persistence.DataEntity;
import lombok.Data;

/**
 * 描述:
 * 新闻类
 *
 * @author onlymark
 * @create 2018-09-07 下午3:45
 */
@Data
public class News extends DataEntity {

    /**
     * 标题（50）
     */
    private String title;

    /**
     * 标题图片
     */
    private String titleImg;

    /**
     * 作者
     */
    private String author;

    /**
     * 阅读数
     */
    private Integer readCounts;

    /**
     * 点赞数
     */
    private Integer tipGood;

    /**
     * 内容
     */
    private String content;

    /**
     * 排序
     */
    private Integer sort;

}
