package com.wjj.sentinel.controller;

import com.wjj.sentinel.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wjj
 * @create 2021/11/24
 * @Description
 */
@RestController
public class SentinelFeignController {

    @Autowired
    ProviderService providerService;

    @GetMapping("/testFeignSentinel")
    public String testFeignSentinel(){
        String result = providerService.testDemoP();
        return result;

    }
}
