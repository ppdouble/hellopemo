package com.pxample.pemo;

import com.pxample.pemo.servlet.HelloFilter;
import com.pxample.pemo.servlet.HelloListener;
import com.pxample.pemo.servlet.HelloServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan
public class PemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PemoApplication.class, args);
	}

	/* @ServletComponentScan
	 * @WebServlet(name = "HelloServlet", value = "/helloservlet")
     * public class HelloServlet extends HttpServlet {}
	 * @WebFilter(filterName = "helloFilter", urlPatterns = "/hellofilter")
	 * public class HelloFilter implements Filter {}
	 * @WebListener
	 * public class HelloListener implements ServletContextListener {
	 */
	 // above code can replace below code
	/*
	@Bean
	public ServletRegistrationBean getServletRegistrationBean() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new HelloServlet());
		servletRegistrationBean.addUrlMappings("/helloservlet");
		return servletRegistrationBean;
	}

	@Bean
	public FilterRegistrationBean getFilterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new HelloFilter());
		filterRegistrationBean.addUrlPatterns("/hellofilter");
		return filterRegistrationBean;
	}

	@Bean
	public ServletListenerRegistrationBean<HelloListener> getServletListenerRegistrationBean() {
		ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean(new HelloListener());
		return servletListenerRegistrationBean;
	}

	 */

}
