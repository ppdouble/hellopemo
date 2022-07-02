## Servlet

Two ways to use servlet:

**Method 1**

In the entry class of Application using `@ServletComponentScan`.

In the controller the code could be writing as below:

```java
@WebServlet(name = "HelloServlet", value = "/helloservlet")
public class HelloServlet extends HttpServlet {}
```
```java
@WebFilter(filterName = "helloFilter", urlPatterns = "/hellofilter")
public class HelloFilter implements Filter {}
```

```java
@WebListener
public class HelloListener implements ServletContextListener {}
```

**Method 2**

treated all stuff as bean and registered controller in the entry class of application

```java
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
```

## Return json string
Two ways:

**Method 1**
`@RestController` to the controller class
```java
@RestController
public class HelloController {
    
    private Map<String, Object> result = new HashMap<>();
    ...
    @RequestMapping("/hello")
    public Map<String, Object> hello() {
        ...
        return result;
    }
}
```

**Method 2**
`@Controller` to the controller class and `@ResponseBody` to the method
```java
@Controller
public class HelloController {

    private Map<String, Object> result = new HashMap<>();
    ...
    @RequestMapping("/hello")
    @ResponseBody
    public Map<String, Object> hello() {
        ...
        return result;
    }
}
```

## Render to freemarker

Three tips:

1. Do not use `@ResponseBody` or `@RestController`
2. The controller should return the file name (without suffix) of the template file
3. The variable name which add to `Model` should be same with the variable in the template file

***controler***
```java
@Controller
public class StudentList {
 
    @RequestMapping("/liststudents")
    public String studentlist(Model model) {
        List<Student> studentList = new ArrayList<>();
        ...
        model.addAttribute("slist", studentList); // the attrbuteName should same with the corresponding variable the template file
        return "studentlist"; // same with the template file name
    }
}

```
***template***

`studentlist.ftlh`
```html
    <#list slist as student>
    <tr>
        <td>${student.id}</td>
        <td>${student.studentName}</td>
        <td>${student.grade}</td>
    <tr>
    </#list>
```
***other***

`application.properties`
```text
# Default value true
#spring.freemarker.enabled=true
# Default value /templates
#spring.freemarker.template-loader-path=classpath:/templates
# Default value ftlh
#spring.freemarker.suffix=.ftlh
```
`pom.xml`
```xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-freemarker</artifactId>
		</dependency>
```