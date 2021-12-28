package com.wjj.springdemo.proxy;

//import java.lang.reflect.Proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author wjj
 * @create 2021/12/28
 * @Description JDK动态代理：通过被代理对象实现的接口产生其代理对象
 */
public class JDKDynamicProxy implements InvocationHandler{

    /**
     * 被代理的对象
     */
    private Object obj;

    /**
     * 传入被代理的对象
     * @param obj
     */
    public JDKDynamicProxy(Object obj) {
        this.obj = obj;
    }


    /**
     * 获取代理对象
     */
    public Object getProxy(){
        //获取类加载器
        ClassLoader classLoader = obj.getClass().getClassLoader();
        //获取被代理对象的接口
        Class<?>[] interfaces = obj.getClass().getInterfaces();

      /*
         //方式1：匿名实现
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        };
        Object o = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        */


        //方式2： 通过本类直接实现invocationHandler
        //产生代理对象
        //第三个参数：使用代理对象调用方法时，用于拦截方法的拦截器
        Object o = Proxy.newProxyInstance(classLoader, interfaces, this);
        return o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName()+"开始执行，执行前操作.......");
        //执行方法
        Object returnValue = method.invoke(obj, args);
        System.out.println(method.getName()+"结束执行，执行后操作.........");
        return returnValue;
    }
}
