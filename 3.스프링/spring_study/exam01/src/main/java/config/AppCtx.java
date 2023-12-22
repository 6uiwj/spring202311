package config;

import models.Greeter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

    @Bean
    public Greeter greeter(){
        return new Greeter();
    }
}
