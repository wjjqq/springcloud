package com.wjj.zookeeper.springcloud01zookeeper.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wjj
 * @create 2021/11/16
 * @Description
 */
@RestController
@Slf4j
public class ProviderController {
    @GetMapping("/testZookeeper")
    public String testZookeeper(){
        return "call provider is success";
    }

}
