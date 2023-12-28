package controllers.admin;

//import ch.qos.logback.core.model.Model;
import controllers.member.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import models.member.Member;
import models.member.MemberDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("adminMemberController")
@RequestMapping("/admin/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberDao memberDao;
    @GetMapping  // /admin/member
    //회원데이터를 가져와 속성으로 추가
    //NPE 오류를 방지하기 위해 빈 객체 생성(@ModelAttribute)
    //커맨드 객체를 @ModelAttribute 로...
    public String index(@ModelAttribute MemberSearch search, Errors errors, Model model){

        List<Member> members = memberDao.getList(search);
        model.addAttribute("members",members);
        members.forEach(System.out::println);
        return "admin/member/list";
    }
    // /admin/member/회원아이디
    //회원정보조회
    //{} : 바뀔 수 있는 경로 변수
    //@PathVariable 경로변수에 주입할 값
    @GetMapping("/{id}")
    public String info(@PathVariable("id") String userId) {
        System.out.println(userId);
        return "admin/member/info";
    }

    //예외처리
    @GetMapping("/test")
    public String errorTest(){
        boolean result = true;
        if(result) {
            //throw new RuntimeException("예외 발생!!!!");
            //404가 출력되어야 함
            throw new MemberNotFoundException();
        }
        return "admin/member/info";
    }

    //admin쪽의 Membercontroller에만 적용되는 에러 처리
    // 모든 controller에 공통으로 적용되도록 해줘야 한다. -> RuntimeException을 Exception으로 변경
    /*
    @ExceptionHandler(Exception.class)
    public String errorHandler(Exception e, Model model) {
        e.printStackTrace();
        //사용자 쪽에 보낼 메시지 정의
        model.addAttribute("message", e.getMessage());


        return "error/common";

    }

     */
}

