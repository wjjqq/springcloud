package com.wjj.mvc.config;


import com.wjj.mvc.interceptor.MyHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author wjj
 * @create 2021/12/24
 * @Description 配置spring相关内容
 */
@Configuration
public class WebMvcConfig  implements WebMvcConfigurer {

    //自定义拦截器
    @Autowired
    MyHandlerInterceptor myHandlerInterceptor;

    /**
     * 皮质拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //增加拦截器，拦截testInterceptor请求
        registry.addInterceptor(myHandlerInterceptor).addPathPatterns("/testInterceptor");
    }

}
