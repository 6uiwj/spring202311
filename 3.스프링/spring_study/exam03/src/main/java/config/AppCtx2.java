package config;

import models.member.JoinService;
import models.member.JoinValidator;
import models.member.ListService;
import models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value={AppCtx3.class})
//value가 하나일 경우 다음과 같이써도 됨
//@Import({AppCtx3.class})
//@Import(AppCtx3.class)
public class AppCtx2 {

    @Bean
    public JoinValidator joinValidator() {
        return new JoinValidator();
    }

    @Bean
    public JoinService joinService() {
        return new JoinService();
    }
    @Bean
    public ListService listService() {
        return new ListService();
    }
}
