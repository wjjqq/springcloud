package com.wjj.springdemo.test;

import com.wjj.springdemo.dao.GeneralDao;
import com.wjj.springdemo.dao.impl.GeneralDaoImpl;
import com.wjj.springdemo.proxy.CGlibDynamicProxy;
import com.wjj.springdemo.proxy.JDKDynamicProxy;

/**
 * @Author wjj
 * @create 2021/12/28
 * @Description
 */
public class TestJDKDynamicProxy {


    public static void main(String[] args) {
        GeneralDaoImpl testDao = new GeneralDaoImpl();
       /*

       //JDK代理测试
       GeneralDao proxy = (GeneralDao)new JDKDynamicProxy(testDao).getProxy();
//        testDao.methodTest();
        //使用代理对象调用方法，并不会执行被调用的方法，而是进入创建代理对象时指定的InvocationHandler的invoke方法
        //调用的方法作为参数作为invoke的method参数
//        proxy.methodTest();
        proxy.methodTest2("这是一个入参");*/



       //CGLIB代理测试
        GeneralDaoImpl proxy = (GeneralDaoImpl)new CGlibDynamicProxy(testDao).getProxy();
//        proxy.methodTest();
        proxy.methodTest2("这是一个入参");


    }
}
