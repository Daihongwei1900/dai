package com.dai.TransactionManager.factory;

import com.dai.TransactionManager.service.IAccountService;
import com.dai.TransactionManager.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


@Component
public class BeanFactory {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private TransactionManager txManager;
    public IAccountService getAccountService(){
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            //添加事务的支持
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if ("test".equals(method.getName())){
                    return method.invoke(accountService,args);
                }
                Object rtValue=null;
                try{
                    txManager.beginTransaction();
                    rtValue = method.invoke(accountService,args);
                    txManager.commit();
                    return rtValue;
                }catch (Exception e){
                    txManager.rollback();
                    throw  new RuntimeException("转账失败");
                }finally {
                    txManager.release();
                }
            }
        });
    }

}
