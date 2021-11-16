package com.wjj.zookeeper.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author wjj
 * @create 2021/11/16
 * @Description
 */
@RestController
@Slf4j
public class CustomerController {
    public static final String INVOKER_URL="http://zookeeper-provider";
    @Resource
    RestTemplate restTemplate;
    @GetMapping("testCall")
    public String testZookeeper(){
        String result = restTemplate.getForObject(INVOKER_URL+"/testZookeeper", String.class);
        return result;
    }
}
