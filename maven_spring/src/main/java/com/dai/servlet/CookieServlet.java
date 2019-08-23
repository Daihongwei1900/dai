package com.dai.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/cookieServlet")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie1:cookies){
            System.out.println(cookie1.getName()+cookie1.getValue());
        }
        Cookie cookie = new Cookie("msg","持久");
        cookie.setMaxAge(60*60*60);
        response.addCookie(cookie);
        HttpSession session = request.getSession();
        session.setAttribute("msg",1);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}