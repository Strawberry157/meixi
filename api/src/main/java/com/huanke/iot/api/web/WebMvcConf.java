package com.huanke.iot.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public  class WebMvcConf extends WebMvcConfigurerAdapter {

    @Autowired
    private ProcessInterceptor processInterceptor;

    @Autowired
    private MeixiLoginInterceptor meixiLoginInterceptor;

    /**
     * 请求拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册监控拦截器
        registry.addInterceptor(processInterceptor)
                .addPathPatterns("/**");
        registry.addInterceptor(meixiLoginInterceptor).
                addPathPatterns("/meixi/**").excludePathPatterns("/meixi/register/**")
                .excludePathPatterns("/meixi/login/requestToken");

    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将所有/static/** 访问都映射到classpath:/static/ 目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(120);
    }
}
