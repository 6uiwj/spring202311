package config;

import models.member.JoinService;
import models.member.JoinValidator;
import models.member.ListService;
import models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Configuration 설정 클래스임을 알려주는 annotaion
@Configuration
public class AppCtx {
    //Bean : 스프링이 관리하는 객체임을 알려주는 Annotation
    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    //JoinValidator는 MemberDao에 의존하고 있음
    @Bean
    public JoinValidator joinValAidator() {
        return new JoinValidator(memberDao());
    }

    //두가지에 의존하고 있음 (memberDao, joinValidator)
    @Bean
    public JoinService joinService() {
        return new JoinService(memberDao(), joinValAidator());
    }
    @Bean
    public ListService listService() {
        ListService listService = new ListService();
        listService.setMemberDao(memberDao());

        return listService;

    }

}
