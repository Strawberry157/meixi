package com.huanke.iot.api.controller.meixi;

import com.huanke.iot.api.controller.meixi.request.RegistRequest;
import com.huanke.iot.api.controller.meixi.request.SendCodeRequest;
import com.huanke.iot.api.service.meixi.UserAuthService;
import com.huanke.iot.base.api.ApiResponse;
import com.huanke.iot.base.constant.RetCode;
import com.huanke.iot.base.constant.UserRegisterConstants;
import com.huanke.iot.base.po.UserAuth;
import com.huanke.iot.base.util.GfJsonUtil;
import com.huanke.iot.base.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 描述:注册controller
 *
 * @author onlymark
 * @create 2018-09-07 下午5:48
 */
@RestController
@RequestMapping("/meixi/register")
@Slf4j
public class RegistController {
    @Autowired
    private UserAuthService userAuthService;

    /**
     * 发送验证码
     *
     * @param request
     * @return
     */
    @RequestMapping("sendCode")
    public Object sendCode(@Valid @RequestBody SendCodeRequest request) {
        log.info("用户注册-发送验证码: request={}", GfJsonUtil.toJSONString(request));
        Object vo = userAuthService.sendVerifyCode(request.getMobile());
        log.info("用户注册-发送验证码: vo={}", GfJsonUtil.toJSONString(vo));
        return vo;
    }

    @RequestMapping("/save")
    public Object save(@Valid @RequestBody RegistRequest request) {
        log.info("注册: request={}",GfJsonUtil.toJSONString(request));
        //查看手机号是否已存在
        UserAuth userAuth = userAuthService.getByIdentifier(request.getMobile());
        if(userAuth != null){
            return new ApiResponse<>(RetCode.ERROR, "当前手机号码已被注册");
        }
        UserAuth newUserAuth = new UserAuth();
        newUserAuth.setIdentifier(request.getMobile());
        newUserAuth.setIdentityType(UserRegisterConstants.register_type_mobile);
        newUserAuth.setCredential(MD5Util.md5(request.getPassword()));
        //校验验证码
        userAuthService.jointSave(newUserAuth);
        return new ApiResponse<>();
    }
}
