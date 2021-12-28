package com.wjj.springdemo.test;

import com.wjj.springdemo.dao.GeneralDao;
import com.wjj.springdemo.dao.impl.GeneralDaoImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wjj
 * @create 2021/12/28
 * @Description
 */
@RestController
public class TestAop {
    @GetMapping("/testAop")
    public String testAop(){
        GeneralDao generalDao = new GeneralDaoImpl();
        generalDao.methodTest();
        return "success";
    }
}
