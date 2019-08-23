package com.dai.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/fileLoadServlet")
public class FileLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename =request.getParameter("filename");
        ServletContext servletContext = request.getServletContext();
        String realPath = servletContext.getRealPath("/img/"+filename);
        FileInputStream fis = new FileInputStream(realPath);
        System.out.println(filename);
        //设置响应头
        String mimetype = servletContext.getMimeType(filename);
        response.setHeader("content-type",mimetype);

        String agent =request.getHeader("user-agent");
        filename = DownLoadUtils.getFileName(agent,filename);

        ServletOutputStream servletOutputStream =response.getOutputStream();
        byte[] buff = new byte[1024*8];
        int len =0 ;
        while ((len=fis.read(buff))!=-1){
            servletOutputStream.write(buff,0,len);
        }
        fis.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
    }
}