package main.java.listener;

import com.mongodb.MongoClient;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.UnknownHostException;

public class MongoDBContextListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            ServletContext context = servletContextEvent.getServletContext();
            MongoClient mongoClient = new MongoClient(
                    context.getInitParameter("MONGODB_HOST"),
                    Integer.parseInt(context.getInitParameter("MONGODB_PORT"))
            );
            System.out.println("MongoClient initialized successfully");

            servletContextEvent.getServletContext().setAttribute("MONGO_CLIENT", mongoClient);

        }catch (UnknownHostException e){
            throw new RuntimeException();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        MongoClient mongoClient = (MongoClient) servletContextEvent.getServletContext()
                .getAttribute("MONGO_CLIENT");
        mongoClient.close();

        System.out.println("MongoClient closed successfully");
    }
}
