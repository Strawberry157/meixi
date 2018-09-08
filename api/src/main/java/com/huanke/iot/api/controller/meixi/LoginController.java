package com.huanke.iot.api.controller.meixi;

import com.huanke.iot.api.controller.meixi.request.LoginUserRequest;
import com.huanke.iot.api.service.meixi.UserloginService;
import com.huanke.iot.base.util.GfJsonUtil;
import com.huanke.iot.base.util.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 描述:
 * 登陆controller
 *
 * @author onlymark
 * @create 2018-09-07 下午5:04
 */
@RestController
@RequestMapping("/meixi/login")
@Slf4j
public class LoginController {
    @Autowired
    private UserloginService userloginService;
    /**
     * 登录获取requestToken
     * @param request 用户名
     * @return token result
     */
    @RequestMapping("requestToken")
    public Object requestToken(@Valid @RequestBody LoginUserRequest request) {
        log.info("登录获取requestToken: request={} ", GfJsonUtil.toJSONString(request));
        Object token = null;
        return userloginService.requestToken(request, IPUtils.getRemoteAddress());
    }



}
