package com.imooc.aop.demo3;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyBeforeAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] args, Object target) throws Exception {
        System.out.println("前置增强======================");
    }
}
