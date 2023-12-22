package org.choongang.controllers.member;

import lombok.extern.slf4j.Slf4j;
import org.choongang.entities.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {
    @GetMapping("/join")
    public String join() {
        log.info("로그 메시지!");
        //{} : 치환되는 부분
        log.info("로그 {}, {}", "값1", "값2");
        return "member/join";
    }
    @ResponseBody
    @GetMapping("/info")
    public Member info() {
        Member member = Member.builder()
                .userNo(1L)
                .userPw("12345678")
                .userId("user01")
                .userNm("사용자01")
                .email("user01@test.org")
                .regDt(LocalDateTime.now())
                .modDt(LocalDateTime.now())
                .build();

        return member;
    }
}
