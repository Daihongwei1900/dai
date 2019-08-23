package com.dai.exception.controller;

import com.dai.exception.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error")
public class ExceptionController {


    @RequestMapping("/testException")
    public String testException() throws SysException {
        System.out.println("testException执行了...");

        try {
            // 模拟异常
            int a = 10/0;
        } catch (Exception e) {
            // 打印异常信息
            e.printStackTrace();
            // 抛出自定义异常信息
            throw new SysException("查询所有用户出现错误了...");
        }
        return "success";
    }
    @RequestMapping("/testWeb")
    public ModelAndView testWeb(){
        System.out.println("testWeb执行了");
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("success");
        return modelAndView;
    }

}
