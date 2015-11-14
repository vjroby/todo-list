package ro.robertgabriel.configuration;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityBootstrap extends AbstractSecurityWebApplicationInitializer{

    @Override
    protected boolean enableHttpSessionEventPublisher() {
        return  true;
    }
}
