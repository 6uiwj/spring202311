package configs;

import controllers.HelloController;
import controllers.member.MemberController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//모델쪽에 있는게 싹 다 추가될 수 있도록 스캔 범위 바꿔주기. ComponentScan에 "models"추가
@Configuration
@ComponentScan({"controllers","models"})
public class ControllerConfig {

    /*
    @Bean
    public HelloController helloController() {
        return new HelloController();
    }
    @Bean
    public MemberController memberController() {
        return new MemberController();
}

     */
    }
