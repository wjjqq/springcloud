package com.wjj.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wjj
 * @create 2021/11/18
 * @Description
 */
@Configuration
public class FeignConfig {
//    设置feign的日志级别
    @Bean
    Logger.Level feignLogLevel(){
        return Logger.Level.FULL;
    }
}
