package org.choongang.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.choongang.entities.Member;
import org.choongang.restcontrollers.RequestJoin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc //설정 자동추가
public class ApiTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    @DisplayName("회원 가입 성공시 응답 코드 201")
    void joinTest() throws Exception {
        //MediaType.APPLICATION_JSON == application/json

        //양식
        RequestJoin form = new RequestJoin();
        form.setUserId("user01");
        form.setUserPw("12345678");
        form.setConfirmPw("12345678");
        form.setUserNm("사용자01");
        form.setEmail("user01@test.org");
        form.setRegDt(LocalDateTime.now());

        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule()); //LocalDateTime 변환하는 모듈 추가

        String body = om.writeValueAsString(form); //자바 객체 -> JSON 문자열 반환

        System.out.println(body);

        //print: 요청 응답에 대한 상세 정보
        //content: body에 쓸 내용
        mockMvc.perform(
                post("/api/member")
                        //.header("Content-Type", "application/json")
                        .header("Content-Type", MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(body)
                )
                .andDo(print())
                .andExpect(status().isCreated()); //201이 맞는지 체크하는 부분임
    }

    @Test
    @DisplayName("JSON 문자열 -> Member 객체로 변환")
    void infoTest() throws Exception {
       String body =  mockMvc.perform(get("/api/member"))
                .andDo(print())
                .andReturn().getResponse()
                .getContentAsString(Charset.forName("UTF-8"));   //andreturn: 응답데이터를 반환받을 때

       // System.out.println(body);
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());

        Member member = om.readValue(body, Member.class);
        System.out.println(member);
    }

    @Test
    void listTest() throws Exception {
        //목록데이터 가져오기 .andDO(print()) -> 자바 객체로 변환해야 한다.
        String body = mockMvc.perform(get("/api/member/list"))
                .andDo(print()) //목록데이터 가져오기 .andDO(print()) -> 자바 객체로 변환해야 한다.
                .andReturn()  //.andReturn(): 응답 내용 확인
                .getResponse()
                .getContentAsString(Charset.forName("UTF-8"));//바디데이터를 가져오고 인코딩(문자열반환)

        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
        //리스트로 변환
        //단일- Class clazz / 단일 X  - TypeReference
        //얘는 추상클래스이므로 {}이걸 넣어줘야 한대..
        List<Member> members = om.readValue(body, new TypeReference<>() {} );
        members.forEach(System.out::println);

    }
}
