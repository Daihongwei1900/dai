package com.dai.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyCglib {
    public static void main(String[] args) {
       final Producer producer = new Producer();
        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object returnValue = null;
                Float money = (Float) objects[0];
                if ("saleProduct".equals(method.getName())){
                    returnValue=method.invoke(producer,money*0.8f);
                    return returnValue;
                }
              return method.invoke(producer, objects);
            }
        });
        cglibProducer.saleProduct(12000f);
    }
}
