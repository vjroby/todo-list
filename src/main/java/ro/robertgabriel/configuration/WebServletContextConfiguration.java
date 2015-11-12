package ro.robertgabriel.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import ro.robertgabriel.controllers.HomeController;
import ro.robertgabriel.controllers.ListsController;
import ro.robertgabriel.dao.MongoDBItemsDao;
import ro.robertgabriel.dao.MongoDBListDao;

import javax.inject.Inject;

@Configuration
@EnableWebMvc
public class WebServletContextConfiguration extends WebMvcConfigurerAdapter{
    @Inject
    ro.robertgabriel.frontend.Configuration frontEndConfiguration;
    @Inject
    MongoDBListDao mongoDBListDao;
    @Inject
    MongoDBItemsDao mongoDBItems;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("WEB-INF/resources/");
    }

    @Bean
    public HomeController homeController()
    {
        HomeController homeController = new HomeController();
        homeController.setConfiguration(frontEndConfiguration);
        return homeController;
    }

    @Bean
    public ListsController listsController()
    {
        ListsController listsController = new ListsController();
        listsController.setMongoDBItemsDao(mongoDBItems);
        listsController.setMongoDBListDao(mongoDBListDao);
        return  listsController;
    }
}
