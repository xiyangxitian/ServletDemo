package com.iotek.jee.servlet.lifecycle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet3 extends HttpServlet {


    private static final long serialVersionUID = 5713084648341464741L;

    @Override
    public void init(ServletConfig config) throws ServletException {
        print("init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        print("service");
    }

    @Override
    public void destroy() {
        print("destroy");
    }

    void print(String content) {
        System.out.println(getClass().getSimpleName() + " method name:" + content + " thread name:" + Thread.currentThread().getName());
    }
}
