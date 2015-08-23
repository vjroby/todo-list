package main.java.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MongoDBContextListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Context initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Context destroyed");
    }
}
