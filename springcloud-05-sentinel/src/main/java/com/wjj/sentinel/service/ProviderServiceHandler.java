package com.wjj.sentinel.service;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author wjj
 * @create 2021/11/24
 * @Description
 */
@Service
public class ProviderServiceHandler implements ProviderService{


    @Override
    public String testDemoP() {
        return "provider is exception";
    }
}
