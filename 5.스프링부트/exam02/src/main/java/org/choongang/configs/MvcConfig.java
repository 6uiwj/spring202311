package org.choongang.configs;

        import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing //EntityListener 설정 활성화
public class MvcConfig implements WebMvcRegistrations {

}
