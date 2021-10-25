package com.wjj.service.impl;

import com.wjj.service.DubboProviderService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @Author wjj
 * @create 2021/10/22
 * @Description
 */
@DubboService
public class DubboProviderServiceImpl implements DubboProviderService {
    @Override
    public String sayHello() {
        String testStr = "dubbo test success";
        return testStr;
    }
}
