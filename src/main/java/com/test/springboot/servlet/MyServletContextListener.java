package com.test.springboot.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Slf4j
@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("My Servlet ContextListener listen project initialized completed");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("My Servlet ContextListener listen project destroy completed");
    }
}
