package com.huanke.iot.api.controller.meixi;

import com.huanke.iot.api.controller.meixi.request.UserInfoRequest;
import com.huanke.iot.api.controller.meixi.vo.UserInfoVo;
import com.huanke.iot.api.service.meixi.UserService;
import com.huanke.iot.base.api.ApiResponse;
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
 *
 * @author onlymark
 * @create 2018-09-08 下午1:27
 */
@RestController
@RequestMapping("/meixi/user")
@Slf4j
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    /**
     * 新用户完善个人信息
     * @param request
     * @return
     */
    @RequestMapping("perfectInfo")
    public Object perfectInfo(@Valid @RequestBody UserInfoRequest request) {
        String ipAddress = IPUtils.getRemoteAddress();
        Integer userId = getCurrentUserId();
        log.info("新用户完善个人信息requestToken: request={}, userId={}, ipAddress={} ", GfJsonUtil.toJSONString(request), userId, ipAddress);
        userService.perfectInfo(userId, request, ipAddress);
        return new ApiResponse<>();
    }

    /**
     * 获取个人信息
     * @return
     */
    @RequestMapping("getInfo")
    public Object getInfo() {
        Integer currentUserId = getCurrentUserId();
        log.info("当前用户id={}", currentUserId);
        UserInfoVo userInfoVo = userService.getInfo(currentUserId);
        return new ApiResponse<>(userInfoVo);
    }

}
