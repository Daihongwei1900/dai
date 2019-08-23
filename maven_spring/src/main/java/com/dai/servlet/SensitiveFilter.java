package com.dai.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@WebFilter("/test")
public class SensitiveFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        ServletRequest prox_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
              if (method.getName().equals("getParameter")){
                  String value = (String) method.invoke(req,args);
                  value="888";
                  return value;
              }
                  return method.invoke(req,args);
                }
            });
            chain.doFilter(prox_req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
