package com.dai.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class aopTest {
    @Test
            public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop.xml");
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
        accountService.saveAccount();
        accountService.updateAccount(1);
    }

}
