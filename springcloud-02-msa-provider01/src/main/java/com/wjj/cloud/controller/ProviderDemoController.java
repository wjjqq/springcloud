package com.wjj.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
