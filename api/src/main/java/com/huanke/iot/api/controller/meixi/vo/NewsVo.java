package com.huanke.iot.api.controller.meixi.vo;

import lombok.Data;

/**
 * 描述:
 *
 * @author onlymark
 * @create 2018-09-09 上午10:43
 */
@Data
public class NewsVo {
    private String title;
    private String content;
    private String author;
    private Integer readCounts;
    private Integer tipGood;
}
