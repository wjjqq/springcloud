package com.wjj.sentinel.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author wjj
 * @create 2021/11/24
 * @Description
 */

@FeignClient(value = "msa-provider", fallback = ProviderServiceHandler.class)
public interface ProviderService {
    @GetMapping("/testDemoP")
    public String testDemoP();
}
