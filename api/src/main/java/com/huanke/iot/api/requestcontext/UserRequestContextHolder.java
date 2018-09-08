package com.huanke.iot.api.requestcontext;

/**
 * 描述:
 *
 * @author onlymark
 * @create 2018-09-08 上午11:12
 */
public class UserRequestContextHolder {
    private static ThreadLocal<UserRequestContext> contextThreadLocal = new ThreadLocal<>();

    public static void clear(){
        contextThreadLocal.remove();
    }

    public static UserRequestContext get(){
        UserRequestContext context = contextThreadLocal.get();

        if(context== null){
            context = new UserRequestContext();
            contextThreadLocal.set(context);
        }
        return context;
    }
}
