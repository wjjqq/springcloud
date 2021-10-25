package com.wjj.controller;

import com.wjj.service.DubboProviderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wjj
 * @create 2021/10/25
 * @Description
 */
@RestController
@Slf4j
public class TestController {

    @DubboReference
    DubboProviderService service;

    @GetMapping("testInterface")
    public String testInterface(){
        String result = service.sayHello();
        log.info("result:"+result);
        return result;

    }

}
