package configs;

import commons.Utils;
import controllers.member.JoinValidator;
import controllers.member.MemberController;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@Import(DbConfig2.class)
public class MvcConfig implements WebMvcConfigurer {

    //다형성...
    @Autowired
    private ApplicationContext applicationContext;


    //적합하지 않지만 적용되는 것을 보여주기 위해 써보자...
    /*
    @Autowired
    private JoinValidator joinValidator;

    @Override
    public Validator getValidator() {
        return joinValidator;
    }

     */
    @Bean
    public MemberOnlyInterceptor memberOnlyInterceptor() {
        return new MemberOnlyInterceptor();
    }
    @Bean
    public CommonInterceptor commonInterceptor() {
        return new CommonInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //인터셉터 적용할 url 넣어주기
        registry.addInterceptor(memberOnlyInterceptor())
                .addPathPatterns("/mypage/**");

        //모든 경로가 commonInterceptor를 거친다.
        registry.addInterceptor(commonInterceptor())
                .addPathPatterns("/**");

    }




    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
        //모든 요청 -> 컨트롤러 빈, 없는 경우 -> 정적 자원 경로(css, js, 이미지..)
    }

    //controller bean에 없으면 2차적으로 여기서 찾는다.
    //(정적자원연결부분)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        // 슬래시 /는 escape 문자로 인식하니까...제거됨 /// 3개를 써야 2개가 남는다...
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:///c:/uploads/");
    }

    //configureViewResolver: view를 찾기 위한 설정
    //(앞에 붙는 경로와, 뒤에 붙는 확장자 설정) <- 이 경로로 view를 찾음


    //addViewControllers : 따로 컨트롤러를 만들지 않아도 아래의 주소와 페이지를 연동할 수 있음.
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/")
                .setViewName("main/index");
        //템플릿연동
        registry.addViewController("/mypage/**")
                .setViewName("mypage/index");
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        //반환값이 오게되면 앞에 오는 부분
        templateResolver.setPrefix("/WEB-INF/templates/");
        //뒤에 붙는 부분
        templateResolver.setSuffix(".html");
        /*
        cacheable - true: 최초 로딩 시 한번 번역하고 다음 요청시에는 기존 번역된 결과물을 그대로 재활용
                  -false: 템플릿에 무언가를 자주 추가하고 바꾸기 때문에 서버를 껏다 켤 때마다 바뀌면
        번거로우니까 요청시마다 다시 번역한다.(주로 개발 중일 때 사용)

         */

        templateResolver.setCacheable(false);
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        //EL식 사용 활성화 여부
        templateEngine.setEnableSpringELCompiler(true);
        //Dialect : 확장기능
        //Java8Time : Date Time Api(java.time 패키지) - #temporals객체 추가 -> 날짜에 대한 형식화
        templateEngine.addDialect(new Java8TimeDialect());
        //레이아웃 기능 추가
        templateEngine.addDialect(new LayoutDialect());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        //이 페이지의 컨텐츠타입 미리 설정 -> 따라서 JSP파일에서 생략이 가능
        resolver.setContentType("text/html");
        resolver.setCharacterEncoding("utf-8");
        resolver.setTemplateEngine(templateEngine());
        return resolver;
    }

    //최종설정 삽입
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(thymeleafViewResolver());
    }
    @Bean
    public MessageSource messageSource() {
        //구현클래스
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.setDefaultEncoding("UTF-8");
        ms.setBasenames("messages.commons", "messages.validations");

        return ms;
    }
    @Bean
    public Utils utils() {
        return new Utils();

    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer configurer() {
        PropertySourcesPlaceholderConfigurer conf = new PropertySourcesPlaceholderConfigurer();
        conf.setLocations(
                new ClassPathResource("application.properties")
        );
        return conf;
    }
}
