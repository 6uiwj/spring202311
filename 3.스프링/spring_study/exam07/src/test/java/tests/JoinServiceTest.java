package tests;

import configs.ControllerConfig;
import configs.DbConfig;
import configs.MvcConfig;
import controllers.member.JoinValidator;
import controllers.member.RequestJoin;
import models.member.JoinService;
import models.member.Member;
import models.member.MemberDao;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertTrue;

//조인 서비스기능을 테스트하기 위한 클래스
//나중에 통합 테스트를 할거니까
//CF) 통합할 때에는 Controller, config 두개를 추가해야 함
//@Transactional : 실행된 후 다시 rollback된다. (테스트 작업은 실행될 필요가 없기 때문)
@Transactional
@SpringJUnitWebConfig
@ContextConfiguration(classes = {MvcConfig.class, ControllerConfig.class})
public class JoinServiceTest {

    //MockMvc 설정을 위한 의존성 설정(웹에 특화되어 있는 스프링 컨테이너가 필요)
    @Autowired
    private WebApplicationContext ctx;

    //테스트하기 직전에 생성(BeforeEach)
    //통합테스트 진행
    private MockMvc mockmvc;


    @Autowired
    private DataSource dataSource;

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private JoinService service;

    //mockMvc 생성 -> 이제 모의 테스트 가능?
    void setup(){
        mockmvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    //연결 테스트
    @Test
    @DisplayName("데이터베이스 연결 테스트")
    void connectionTest(){
        try (Connection conn = dataSource.getConnection()) {
            System.out.println(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //회원 정보가 존재하는가? 참이 나오면 통과
    @Test
    @DisplayName("MemberDao - exist 메서드 테스트")
    void existTest() {
        String userId = "USER01";
        boolean result = memberDao.exist(userId);
        //체크해볼 수 있는 메서드(참 값이 되면 통과 / 참이 아니면 통과X)
        assertTrue(result);
    }

    //잘 가입되는지, 암호화가 잘 이루어졌는지 테스트
    @Test
    @DisplayName("JoinService - join메서드 테스트")
    void joinTest() {
        //builder를 추가하지 않았으므로 new RequestJoin으로 만들어 줌
        RequestJoin form = new RequestJoin();
        form.setUserId("user01");
        form.setUserPw("12345678");
        form.setUserNm("사용자01");
        form.setEmail("user01@test.org");

        service.join(form);

        Member member = memberDao.get(form.getUserId());
        //가입한 후 가입한 데이터를 조회했을 때 같은지 확인 (테스트 후 바로 rollback 되므로 여기서 확인한다.)
        System.out.println(member);
    }
    @Test
    @DisplayName("회원가입 통합 테스트")
    void joinTest2() throws Exception {
        //모의 요청, 회원가입테스트니까 post
        mockmvc.perform(post("/member/join")
                .param("userId", "user01")
        ).andDo(print());

    }

}
