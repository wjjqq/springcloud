package com.wjj.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wjj
 * @create 2021/12/24
 * @Description
 */
@RestController
public class TestController {


    @GetMapping("/testInterceptor")
    public String testInterceptor(){
        return "success";
    }

    @GetMapping("/testExceptionHandle")
    public String testExceptionHandle(){

        throw new NullPointerException();
//        return "success";

    }




}
