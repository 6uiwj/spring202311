package main;

import config.AppCtx;
import models.Greeter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new
                AnnotationConfigApplicationContext(AppCtx.class);

        Greeter g1 = ctx.getBean("greeter", Greeter.class);
        g1.hello("이이름");

        Greeter g2 = ctx.getBean("greeter", Greeter.class);
        System.out.println(g1==g2);

        ctx.close();
    }
}
