package com.wjj.springdemo.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author wjj
 * @create 2021/12/28
 * @Description
 */
public class CGlibDynamicProxy implements MethodInterceptor {
    /**
     * 被代理对象
     */
    private Object obj;

    public CGlibDynamicProxy(Object obj) {
        this.obj = obj;
    }
    /**
     * 获取代理类
     * @return
     */
    public Object getProxy(){
        Enhancer enhancer = new Enhancer();
        //指定被代理对象为父类
        enhancer.setSuperclass(obj.getClass());
        //指定回调函数
        enhancer.setCallback(this);
        //创建代理对象
        Object object = enhancer.create();
        return object;
    }
    /**
     * 同JDK代理中的invoke方法
     * @param o
     * @param method
     * @param args
     * @param proxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("----------------CGLIB代理");
        System.out.println(method.getName()+"开始执行，执行前操作.......");
        //执行方法
        Object returnValue = method.invoke(obj, args);
        System.out.println(method.getName()+"结束执行，执行后操作.........");
        return returnValue;
    }
}
