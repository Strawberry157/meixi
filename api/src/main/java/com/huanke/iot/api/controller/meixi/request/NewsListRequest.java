package com.huanke.iot.api.controller.meixi.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 描述:
 * 新闻列表请求类
 *
 * @author onlymark
 * @create 2018-09-09 上午10:00
 */
@Data
public class NewsListRequest {
    @NotNull(message = "开始数字不能为空")
    private Integer beginNum;
    @NotNull(message = "条数")
    private Integer length;
}
