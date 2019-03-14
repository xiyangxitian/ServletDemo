package com.iotek.jee.servlet.form;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProcessingServlet extends HttpServlet {

    private static final long serialVersionUID = -5932296226394159524L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决resp返回在浏览器中的中文乱码
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        System.out.println("name:"+name+",age:"+age);
//        String china = req.getParameter("china");
//        System.out.println("china:"+china);
//        String china1 = new String(china.getBytes("ISO8859-1"), "UTF-8");
//        System.out.println("china1:"+china1);
//        //流不需要关闭  tomcat会自动处理
//        resp.setHeader("Content-Type", "text/html,charset=UTF-8");
//        resp.getWriter().write("name:"+name+",age:"+age+",china:"+china+",china11:"+china1);
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");
        resp.getWriter().write("name:"+name+",age:"+age);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        System.out.println("name:"+name+",age:"+age);
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");
        resp.getWriter().write("name:"+name+",age:"+age);
    }



}
