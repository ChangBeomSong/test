package com.test.test.yourapp.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DotenvInitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        EnvLoader.load();
    }
}