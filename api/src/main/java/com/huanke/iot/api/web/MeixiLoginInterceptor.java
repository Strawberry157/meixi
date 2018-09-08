package com.huanke.iot.api.web;

import com.alibaba.fastjson.JSON;
import com.huanke.iot.api.requestcontext.UserRequestContext;
import com.huanke.iot.api.requestcontext.UserRequestContextHolder;
import com.huanke.iot.api.service.meixi.UserService;
import com.huanke.iot.base.api.ApiResponse;
import com.huanke.iot.base.constant.RetCode;
import org.apache.commons.lang.StringUtils;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * 描述:
 * 美希登录拦截器
 *
 * @author onlymark
 * @create 2018-09-07 下午1:48
 */
@Repository
public class MeixiLoginInterceptor extends HandlerInterceptorAdapter {
    private static final String TOKEN = "token";
    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String token = request.getHeader(TOKEN);
        if(StringUtils.isEmpty(token)){
            ApiResponse apiResponse = new ApiResponse(RetCode.TICKET_ERROR,"没有获取到token");
            response.setContentType(ContentType.APPLICATION_JSON.getMimeType());
            response.getWriter().print(JSON.toJSONString(apiResponse));
            return false;
        }else {
            String lastToken = stringRedisTemplate.opsForValue().get(token);
            if (StringUtils.isEmpty(lastToken)) {
                ApiResponse apiResponse = new ApiResponse(RetCode.TICKET_ERROR,"token值已过期");
                response.setContentType(ContentType.APPLICATION_JSON.getMimeType());
                response.getWriter().print(JSON.toJSONString(apiResponse));
                return false;
            }
            String[] tokenArr = lastToken.split("-");
            UserRequestContext requestContext = UserRequestContextHolder.get();
            requestContext.setUserId(Integer.valueOf(tokenArr[0]));
            stringRedisTemplate.expire(token, 10, TimeUnit.DAYS);
            return true;
        }
    }
}
