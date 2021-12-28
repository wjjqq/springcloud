package com.wjj.springdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author wjj
 * @create 2021/12/28
 * @Description
 */

@Aspect
@Component
public class DemoAsepect {

    /**
     * 切入点
     */
    @Pointcut("execution( * com.wjj.springdemo.test.*.*(..))")
    public void addAdvice(){}

    @Around("addAdvice()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("------切入点之前执行");
        Object result = joinPoint.proceed();
        System.out.println("------切入点之前执行");
        return result;
    }
}
