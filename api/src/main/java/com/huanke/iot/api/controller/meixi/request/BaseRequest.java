package com.huanke.iot.api.controller.meixi.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 描述:
 * 基本request
 *
 * @author onlymark
 * @create 2018-09-09 上午10:34
 */
@Data
public class BaseRequest<T> {
    @NotNull(message = "value不能为空")
    private T value;
}
