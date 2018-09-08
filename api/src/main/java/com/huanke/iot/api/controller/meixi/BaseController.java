package com.huanke.iot.api.controller.meixi;

import com.huanke.iot.api.requestcontext.UserRequestContextHolder;

/**
 * 描述:
 * 基础controller
 *
 * @author onlymark
 * @create 2018-09-08 下午1:24
 */
public class BaseController {
    protected Integer getCurrentUserId(){
        Integer userId = UserRequestContextHolder.get().getUserId();
        return userId;
    }
}
