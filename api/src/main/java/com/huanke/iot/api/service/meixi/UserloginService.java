package com.huanke.iot.api.service.meixi;

import com.huanke.iot.api.controller.meixi.request.LoginUserRequest;
import com.huanke.iot.base.api.ApiResponse;
import com.huanke.iot.base.constant.RetCode;
import com.huanke.iot.base.po.User;
import com.huanke.iot.base.po.UserAuth;
import com.huanke.iot.base.util.APIUtils;
import com.huanke.iot.base.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 描述:
 * 用户登陆service
 *
 * @author onlymark
 * @create 2018-09-08 上午8:43
 */
@Service
@Slf4j
public class UserloginService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private UserAuthService userAuthService;
    @Autowired
    private UserService userService;

    /**
     * 获取token
     * @param request
     * @param remoteAddress
     * @return
     */
    public Object requestToken(LoginUserRequest request, String remoteAddress) {
        String credential = MD5Util.md5(request.getPassword());
        UserAuth userAuth = userAuthService.verifyUser(request.getUsername(), credential);
        if(userAuth == null){
            return new ApiResponse<>(RetCode.ERROR, "用户名或密码错误");
        }
        String token = APIUtils.getUUID();
        //更新最后登陆信息
        User user = userService.get(userAuth.getUserId());
        user.setLastLoginTime(new Date());
        user.setLastLoginIp(remoteAddress);
        userService.save(user);
        stringRedisTemplate.opsForValue().set(token, userAuth.getUserId() + "-" + userAuth.getIdentifier());
        stringRedisTemplate.expire(token, 10, TimeUnit.DAYS);

        return new ApiResponse<>(token);
    }


}
