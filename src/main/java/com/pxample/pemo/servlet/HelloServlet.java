package com.pxample.pemo.servlet;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/*
 * Add the @ServletComponentScan under @SpringBootApplication in your helloWorldApplication.
 * The @ServletComponentScan is making SpringBoot scan for @WebServlet annotation and it’s
 *  only performed when using an embedded web server such as Spring Boot.
 */

@WebServlet(name = "HelloServlet", value = "/helloservlet")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("being deployed by doGet method");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
