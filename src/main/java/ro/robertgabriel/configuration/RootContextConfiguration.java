package ro.robertgabriel.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import ro.robertgabriel.dao.MongoDBItemsDao;
import ro.robertgabriel.dao.MongoDBListDao;
import ro.robertgabriel.frontend.Configuration;

//@Import({SecurityConfiguration.class})
@org.springframework.context.annotation.Configuration
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
    public Configuration frontEndConfiguration()
    {
        return new Configuration();
    }
}
