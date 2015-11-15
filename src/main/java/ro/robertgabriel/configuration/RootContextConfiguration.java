package ro.robertgabriel.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ro.robertgabriel.dao.MongoDBItemsDao;
import ro.robertgabriel.dao.MongoDBListDao;
import ro.robertgabriel.frontend.FrontEndConfiguration;

@ComponentScan(
        basePackages = "ro.robertgabriel"
//        excludeFilters =
//        @ComponentScan.Filter({Controller.class, ControllerAdvice.class})
)
@Import({SecurityConfiguration.class})
@Configuration
public class RootContextConfiguration {

    @Bean
    public MongoDBListDao mongoDBListDao ()
    {
        return new MongoDBListDao();
    }

    @Bean
    public MongoDBItemsDao mongoDBItemsDao()
    {
        return new MongoDBItemsDao();
    }

    @Bean
    public FrontEndConfiguration frontEndConfiguration()
    {
        return new FrontEndConfiguration();
    }
}
