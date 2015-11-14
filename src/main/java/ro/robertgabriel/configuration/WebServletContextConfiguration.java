package ro.robertgabriel.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
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

//    @Bean
//    public HomeController homeController()
//    {
//        HomeController homeController = new HomeController();
//        homeController.setConfiguration(frontEndConfiguration);
//        return homeController;
//    }
//
//    @Bean
//    public ListsController listsController()
//    {
//        ListsController listsController = new ListsController();
//        listsController.setMongoDBItemsDao(mongoDBItems);
//        listsController.setMongoDBListDao(mongoDBListDao);
//        return  listsController;
//    }
//    @Bean
//    public LoginController loginController()
//    {
//        return new LoginController();
//    }

    @Bean
    public ViewResolver viewResolver()
    {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
