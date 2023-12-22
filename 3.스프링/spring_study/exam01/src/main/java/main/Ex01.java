package main;

import config.AppCtx;
import models.Greeter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args) {
        //스프링 컨테이너 객체 생성
        //AppCtx: 설정파일 -> 관리할 객체와 의존주입 대상 정보
        AnnotationConfigApplicationContext ctx = new
                AnnotationConfigApplicationContext(AppCtx.class);

        //Bean의 이름: 메서드명
        //getBean(빈의 이름, 빈의 타입) : 필요한 객체를 찾아옴
        Greeter g1 = ctx.getBean("greeter", Greeter.class);
        g1.hello("이이름");

        Greeter g2 = ctx.getBean("greeter", Greeter.class);
        System.out.println(g1==g2);

        ctx.close();
    }
}
