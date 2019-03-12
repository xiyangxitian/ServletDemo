package com.iotek.jee.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("WebContextListener method name:contextInitialized");
        ServletContext servletContext = event.getServletContext();
        String test = servletContext.getInitParameter("test");
        System.out.println("contextInitialized: test:" + test);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("WebContextListener method name:contextDestroyed");
    }
}
