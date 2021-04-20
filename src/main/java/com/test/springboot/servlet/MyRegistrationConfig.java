package com.test.springboot.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;


// proxyBeanMethods = false : we cannot false, this case need below component is singleton
// because if false example when execute FilterRegistrationBean(myFilter,myServlet()) inside
// will every time created new instance put into IOC
@Configuration(proxyBeanMethods = true)
public class MyRegistrationConfig {

    @Bean
    public ServletRegistrationBean<MyServlet> myServlet()
    {
        MyServlet myServlet = new MyServlet();

        return new ServletRegistrationBean(myServlet,"/my");
    }

    @Bean
    public FilterRegistrationBean<MyFilter> myFilter()
    {
        MyFilter myFilter = new MyFilter();

        //return new FilterRegistrationBean(myFilter,myServlet());
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setUrlPatterns(Collections.singletonList("/my"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<MyServletContextListener> myListener()
    {
        MyServletContextListener myServletContextListener = new MyServletContextListener();
        return new ServletListenerRegistrationBean(myServletContextListener);

    }
}
