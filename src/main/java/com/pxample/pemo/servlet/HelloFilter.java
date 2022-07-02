package com.pxample.pemo.servlet;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/*
 * Add the @ServletComponentScan under @SpringBootApplication in your helloWorldApplication.
 * The @ServletComponentScan is making SpringBoot scan for @WebServlet annotation and it’s
 *  only performed when using an embedded web server such as Spring Boot.
 */

@WebFilter(filterName = "helloFilter", urlPatterns = "/hellofilter")
public class HelloFilter implements Filter {

    @Override
    public void doFilter (ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println("I am in method doFilter");
        System.out.println("Executing doFilter method");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Done executing doFilter method");
    }
}
