package com.wjj.cloud.controller;

import com.wjj.cloud.dao.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class CustomerDemoController {

    @Autowired
    ProviderClient providerClient;

    @GetMapping("/testDemoC")
    public String testDemoC(){

        return providerClient.testDemoP();

    }


}
