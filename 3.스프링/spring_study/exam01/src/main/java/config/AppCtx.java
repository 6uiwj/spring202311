package config;

import models.Greeter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //스프링 설정 클래스
public class AppCtx {

    @Bean //스프링 컨테이너 관리 객체
    public Greeter greeter(){

        return new Greeter();
    }
}
