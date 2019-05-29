package com.hfut.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

public class ServletContextServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //第一种使用方式
        ServletContext sc=this.getServletContext();
        //第二种使用方式
        ServletContext sc2=this.getServletConfig().getServletContext();
        //第三中方法
        ServletContext sc3=req.getSession().getServletContext();

        System.out.println(sc==sc2);
        //使用ServletContext对象完成数据共享
        //数据存储
        sc.setAttribute("str","servletContext对象学习");

        //获取项目web.xml中的全局配置数据
        String str=sc.getInitParameter("name");
        System.out.println(str);

        Enumeration<String>data= sc.getInitParameterNames();
        while(data.hasMoreElements()){
            System.out.println(data.nextElement());
        }
        //获取项目根目录下的资源的绝对路径
        String path=sc.getRealPath("/doc");
        System.out.println(path);
        //获取项目根目录下的流对象,,,class对象需要类加载器才行
        InputStream is=sc.getResourceAsStream("/doc/1.txt");
    }
}
