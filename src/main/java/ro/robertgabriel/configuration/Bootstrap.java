package ro.robertgabriel.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@SuppressWarnings("unused")
public class Bootstrap implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        servletContext.getServletRegistration("default").addMapping("/resources/**");

        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();
        rootContext.register(RootContextConfiguration.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));

        AnnotationConfigWebApplicationContext webContext =
                new AnnotationConfigWebApplicationContext();
        webContext.register(WebServletContextConfiguration.class);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
                "springWebDispatcher", new DispatcherServlet(webContext)
        );
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
