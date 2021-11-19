package com.wjj.cloud.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author wjj
 * @create 2021/11/18
 * @Description
 */

@Component
@FeignClient(value = "msa-provider")
public interface ProviderClient {
    @GetMapping("/testDemoP")
    public String testDemoP();



    @GetMapping("/testDemoTimeOut")
    public String testDemoTimeOut();
}
