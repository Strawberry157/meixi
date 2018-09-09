package com.huanke.iot.api.controller.meixi.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 描述:
 * 能力日志request
 *
 * @author onlymark
 * @create 2018-09-09 下午7:54
 */
@Data
public class AbilityLogRequest {
    @DateTimeFormat(pattern="yyyy-MM")
    private Date queryDate;
}
