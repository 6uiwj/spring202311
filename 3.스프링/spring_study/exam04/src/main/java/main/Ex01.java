package main;

import config.AppCtx;
import models.member.JoinService;
import models.member.ListService;
import models.member.Member;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

public class Ex01 {
    public static void main(String[] args) {
        // 애플리케이션 컨텍스트를 초기화할 때 설정 클래스를 지정합니다.
        AnnotationConfigApplicationContext ctx = new
                AnnotationConfigApplicationContext(AppCtx.class);

        //싱글톤 형태로 관리하기 때문에 중복이 되지 않는다...?
        JoinService joinService = ctx.getBean(JoinService.class);
        ListService listService = ctx.getBean(ListService.class);

        Member member = new Member();
        member.setUserId("user01");
        member.setUserPw("123456");
        member.setConfirmPw("123456");
        member.setUserNm("사용자01");
        member.setRegDt(LocalDateTime.now());

        joinService.join(member);

        listService.print();

        ctx.close();
    }
}
