package com.iotek.jee.servlet.lifecycle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {

    private static final long serialVersionUID = -4208389563716122846L;

    @Override
    public void init() throws ServletException {
        String test = getInitParameter("test");
        System.out.println("init-param1:"+test);
    }

/*    @Override
    public void init(ServletConfig config) throws ServletException {
        print("init");
        System.out.println("init-param:"+config.getInitParameter("test"));
    }*/

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        print("service");
    }

    @Override
    public void destroy() {
        print("destroy");
    }

    void print(String content){
        System.out.println(getClass().getSimpleName()+" method name:"+content+" thread name:"+Thread.currentThread().getName());
    }
}
