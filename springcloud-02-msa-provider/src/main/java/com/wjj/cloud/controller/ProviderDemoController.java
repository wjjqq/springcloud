package com.wjj.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author wjj
 * @create 2021/11/18
 * @Description
 */
@RestController
public class ProviderDemoController {
    @Value("${server.port}")
    String serverPort;
    @Value("${spring.application.name}")
    String name;
    @GetMapping("/testDemoP")
    public String testDemoP(){
        return name+":"+serverPort;
    }

    @GetMapping("/testDemoTimeOut")
    public String testDemoTimeOut(){

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return name+":"+serverPort;

    }


}
