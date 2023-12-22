package org.choongang.configs;

import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//스프링부트는 EnableWebMvc.. 안해도 됨
@Configuration
@EnableScheduling
@EnableConfigurationProperties(FileProperties.class) //프로퍼티로 사용할 클래스의 클래스클래스만 나열하면 주입 됨
public class MvcConfig implements WebMvcConfigurer {
    @Autowired
    private FileProperties fileProperties;

    //설정파일을 분리하고 설정 클래스로 가져옴
    //파일 정적 경로 설정 :addResourceHandler
    //html, css , js 정적 경로는 이미 설정되어 있으므로 나머지만 하면 된다.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // /가 2개필요하므로 3개 작성
        registry.addResourceHandler(fileProperties.getUrl() + "**")
                .addResourceLocations("file:///" + fileProperties.getPath());
    }
}
