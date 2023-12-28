package controllers.member;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import models.member.JoinService;
import models.member.LoginService;
import models.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.lang.management.LockInfo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//여기서 데이터를 joinPs로 넘김
@Controller
@RequestMapping("/member")   //공통주소 매핑
@RequiredArgsConstructor //초기화가 필요한 변수들은 다 주입된다.
public class MemberController {

    @Autowired
    private final JoinValidator joinValidator;

    private final JoinService joinService;
    private final LoginValidator loginValidator;
    private final LoginService loginService;

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("자바", "오라클", "JSP", "스프링");
    }

   @GetMapping("/join") // /member/join
   //요청메서드와 주소정보를 가지고 있음, 메서드가 2개일 때에는 배열 형식으로 지정
    //@RequestMapping(method={RequestMethod.GET, RequestMethod.POST},path="member/join")
    public String join(@ModelAttribute RequestJoin form, Model model) {

        //model.addAttribute("requestJoin", new RequestJoin());
        model.addAttribute("pageTitle","회원가입");
        /*
        Member member = Member.builder()
                .userNo(1L)
                .userPw("1234")
                .userId("user01")
                .userNm("<h1>사용자01</h1>")
                .email("user01@test.org")
                .regDt(LocalDateTime.now())
                .build();

        model.addAttribute("member",member);
        model.addAttribute("pageTitle","회원가입");
        //앞뒤에 prepix, surpix가 붙는형태

         */
        return "member/join";

   }



     @PostMapping("/join")
    public String joinPs(@Valid RequestJoin form, Errors errors, Model model){

            joinValidator.validate(form, errors);
            if(errors.hasErrors()) {
                //검증 실패시
                return "member/join";
            }

         //여기까지 넘어오면 문제가 없는 것
         //이후에 회원 가입 처리
         joinService.join(form);

         ///커맨드 객체 RequestJoin -> requestJoin이름으로 속성이 추가
              //-> 템플릿 내에서 바로 접근 가능
         //response.sendRedirect(request.getContextPath() + "/member/login")
         //location: 주소
        return "redirect:/member/login";
         //출력 버퍼 변경
         //return "forward:/member/login";
    }


    @GetMapping("/login")
    public String login(@ModelAttribute RequestLogin form){

        return "member/login";
    }
    @PostMapping("/login") //검증해보자
    public String loginPs(@Valid RequestLogin form, Errors errors){

        loginValidator.validate(form,errors);

        if(errors.hasErrors()) {
            return "member/login";
        }

        //로그인 처리
        loginService.login(form);
        return "redirect:/";  //로그인 성공시 메인페이지로 이동
    }

        //get이든 post이든 주소만 동일하면 다 유입
        @RequestMapping("/logout")
        public String logout(HttpSession session){
            session.invalidate(); //세션 비우기
            //세션은 개인 서비스 기술. 개인데이터가 있음
            //로그아웃했을 때 멤버만 지워도 로그아웃 돼지만
            //데이터가 남을 수 있기 때문에 세션을 전부 비워야한다?

            //로그아웃 하면 로그인 페이지로 이동!
            return "redirect:/member/login"; //로그인 페이지 이동
        }


    @GetMapping("/list")
    public String members(Model model) {

        List<Member> members = new ArrayList<>();
        for(int i= 1; i <= 10; i++) {
            Member member = Member.builder()
                    .userNo(Long.valueOf(i))
                    .userPw("1234")
                    .userId("user"+ i)
                    .userNm("사용자"+i)
                    .email("user"+i+"@test.org")
                    .regDt(LocalDateTime.now())
                    .build();
            members.add(member);
        }
        //데이터를 view에 전달하려면 model을 활용해야 한다.
        model.addAttribute("members",members);
        return "member/list";
    }

    //@InitBinder : 컨트롤러에 해당하는 공통적인 Validator. 뭔 차인데...
    //JoinValidator가 MemberController 에 공통으로..적용...
    /*
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(joinValidator);
    }

     */

}
