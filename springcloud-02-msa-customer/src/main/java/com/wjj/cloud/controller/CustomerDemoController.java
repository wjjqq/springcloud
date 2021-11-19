package com.wjj.cloud.controller;

import com.wjj.cloud.dao.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wjj
 * @create 2021/11/18
 * @Description
 */
@RestController
@RefreshScope//自动刷新nacos配置中心的配置
public class CustomerDemoController {

    @Value("${config.content}")
    private String content;


    @Autowired
    ProviderClient providerClient;
    @GetMapping("/testDemoC")
    public String testDemoC(){
        return providerClient.testDemoP();
    }


    @GetMapping("/testDemoTimeOut")
    public String testDemoTimeOut(){
        return providerClient.testDemoTimeOut();
    }



    @GetMapping("/testConfig")
    public String testConfig(){
        return content;
    }


}
