package com.wjj.sentinel.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wjj.sentinel.model.CommonResult;

/**
 * @Author wjj
 * @create 2021/11/23
 * @Description 用于sentinel流控、降级等相关的异常处理，当不符合相关规则的用于返回自定义结果
 */
public class SentinelBlockHandler {


    public static CommonResult blockException1(BlockException exception){
        return new CommonResult("0001", "exception0001");
    }

    public static String blockException2(BlockException exception){
        return "0002, exception0002";
    }



}
