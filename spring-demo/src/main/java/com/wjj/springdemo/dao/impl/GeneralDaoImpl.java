package com.wjj.springdemo.dao.impl;

import com.wjj.springdemo.dao.GeneralDao;

/**
 * @Author wjj
 * @create 2021/12/28
 * @Description
 */
public class GeneralDaoImpl implements GeneralDao {

    @Override
    public void methodTest() {
        System.out.println("----调用GeneralDaoImpl-----methodTest方法");
    }

    @Override
    public String methodTest2(String str) {
        System.out.println("----调用GeneralDaoImpl-----methodTest方法,入参："+str);
        return str;
    }
}
