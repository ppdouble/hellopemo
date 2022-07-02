package com.pxample.pemo.servlet;

/*
 * Add the @ServletComponentScan under @SpringBootApplication in your helloWorldApplication.
 * The @ServletComponentScan is making SpringBoot scan for @WebServlet annotation and it’s
 *  only performed when using an embedded web server such as Spring Boot.
 */

import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class HelloListener implements ServletContextListener {

    @Override
    public void contextInitialized (ServletContextEvent servletContextEvent) {
        System.out.println("being called at Servlet context Initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("being called at Servlet context Destroyed");
    }
}
