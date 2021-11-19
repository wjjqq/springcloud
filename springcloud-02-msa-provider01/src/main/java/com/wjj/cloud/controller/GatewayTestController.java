package com.wjj.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wjj
 * @create 2021/11/19
 * @Description
 */
@RestController
public class GatewayTestController {
    @Value("${server.port}")
    String serverPort;

    @GetMapping("/test/testOne")
    public String testOne(){
        return "testOne provider: "+serverPort;
    }

    @GetMapping("/test/testTwo")
    public String testTwo(){
        return "testTwo provider: "+serverPort;
    }

    @GetMapping("/testThree")
    public String testThree(){
        return "testThree provider: "+serverPort;
    }
}
