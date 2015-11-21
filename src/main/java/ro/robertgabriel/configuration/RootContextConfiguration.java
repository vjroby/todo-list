package ro.robertgabriel.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import ro.robertgabriel.dao.MongoDBItemsDao;
import ro.robertgabriel.dao.MongoDBListDao;
import ro.robertgabriel.frontend.FrontEndConfiguration;

import java.util.Locale;

@Configuration
@EnableScheduling
@EnableAsync(
        mode = AdviceMode.PROXY, proxyTargetClass = false,
        order = Ordered.HIGHEST_PRECEDENCE
)
@EnableTransactionManagement(
        mode = AdviceMode.PROXY, proxyTargetClass = false,
        order = Ordered.LOWEST_PRECEDENCE
)
@ComponentScan(
        basePackages = "ro.robertgabriel",
        excludeFilters =
        @ComponentScan.Filter({Controller.class, ControllerAdvice.class})
)
//@EnableJpaRepositories
@EnableMongoRepositories(
        basePackages = "ro.robertgabriel.repositories"
)
@Import({SecurityConfiguration.class})
public class RootContextConfiguration {

    private static final Logger log = LogManager.getLogger();
    private static final Logger schedulingLogger =
            LogManager.getLogger(log.getName() + ".[scheduling]");

    @Bean
    public MongoDBListDao mongoDBListDao() {
        return new MongoDBListDao();
    }

    @Bean
    public MongoDBItemsDao mongoDBItemsDao() {
        return new MongoDBItemsDao();
    }

    @Bean
    public FrontEndConfiguration frontEndConfiguration() {
        return new FrontEndConfiguration();
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() throws ClassNotFoundException
     {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setProviderClass(HibernateValidator.class);
        return validator;
    }

    @Bean
    public LocaleResolver localeResolver() {
        final CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
        return cookieLocaleResolver;
    }

    @Bean
    public MessageSource messageSource() {
        final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(0);
        return messageSource;
    }

}
