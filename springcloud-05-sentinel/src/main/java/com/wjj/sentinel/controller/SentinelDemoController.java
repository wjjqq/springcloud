package com.wjj.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wjj.sentinel.handler.SentinelBlockHandler;
import com.wjj.sentinel.model.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wjj
 * @create 2021/11/22
 * @Description
 */
@RestController
public class SentinelDemoController {


    @Value("${spring.application.name}")
    String name;

    @GetMapping("sentinelTest")
    public String sentinelTest(){
        return name;
    }

    @GetMapping("sentinelTestEntity")
    public CommonResult sentinelTestEntity(){
        CommonResult aa = new CommonResult("0000", "sentinelTestEntity is success");
        return aa;
    }

    @GetMapping("sentinelTest2")
    public String sentinelTest2(){
        return name+"2";
    }



    @GetMapping("/sentinelTestByResource")
    @SentinelResource(value = "sentinelTestByResource",
            blockHandler = "handleException")
    public CommonResult sentinelTestByResource() {
        return new CommonResult("0000", "sentinelTestByResource call is success");
    }

    public static CommonResult handleException(BlockException exception){
        return new CommonResult("0009", "handleException");
    }

    /**
     * 自定义sentinel异常处理结果
     * SentinelResource如果sentinel配置的规则失败，
     * 则会调用SentinelBlockHandler的blockException1方法处理结果
     * @return
     */
    @GetMapping("/sentinelResouceTest1")
    @SentinelResource(value = "sentinelResouceTest1",
            blockHandlerClass = SentinelBlockHandler.class,
            blockHandler = "blockException1")
    public CommonResult sentinelResouceTest1() {
        return new CommonResult("0000", "sentinelResouceTest1 call is success");
    }


    @GetMapping("/sentinelResouceTest2")
    @SentinelResource(value = "sentinelResouceTest2",
            blockHandlerClass = SentinelBlockHandler.class,
            blockHandler = "blockException2")
    public String sentinelResouceTest2(){
        return name+"sentinelResouceTest2";
    }

}
