package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    //RequestParam("name") : 항목명을 입력하면 데이터를 가져오고 requestparam이라고 알려줌
    //파라미터명이 name이면 이걸 nm에 주입하겠다.
    //model(데이터) : 데이터를 view에 전달할 목적으로 model을 매개변수로 씀
    @GetMapping("/hello")
    public String hello(@RequestParam(name="name",defaultValue = "기본값") String nm, Model model) {
        //이제 템플릿에서도 조회 가능
        model.addAttribute("name",nm);
        //템플릿 경로를 찾을 수 있게 return
        return "hello";
    }
    /*
    @GetMapping("/hello")
    public String hello(HttpServletRequest request, HttpServletResponse response,
                        HttpSession session) {
       // System.out.println(name+", "+num);
        //반환값: 템플릿번호
        System.out.println("request: " + request);
        System.out.println("Response: " + response);
        System.out.println("session: " + session);
        return "hello"; //WEB-INF/templates/hello.jsp
    }


    /*
    //반환값은 String으로 해도 되고, ModelAndVIew로 해도 됨
    @GetMapping("/hello")
    public ModelAndView hello(){
        ModelAndView mv = new ModelAndView();
        //속성: 데이터, 템플릿에 접근할 수 있는 변수로 추가
        //request.setAttribuyte("messate","안녕하세요.");와 같다.
        mv.addObject("message", "안녕하세요.");
        //템플릿 경로 입력
        mv.setViewName("hello"); // /WEB-INF/templates/hello.jsp
        return mv;
    }

     */
}
