package controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class TestController {
    @GetMapping("/cookie/test1")
    public String test1(HttpServletResponse response, HttpServletRequest request) {
        //쿠키 생성
        Cookie cookie = new Cookie("key1", "value1");
        response.addCookie(cookie);

        Cookie cookie2 = new Cookie("key2", "value2");
        //setPath: 경로 지정
        cookie2.setPath(request.getContextPath()); // /exam07이 경로 하위로 다 적용
        response.addCookie(cookie2); //응답헤더 쪽에 쿠키 2번도 추가되도록
        //7일가 쿠키 유지 설정 - 가독성을 위해 * 형태로 나타냄
        cookie2.setMaxAge(60 * 60 * 24 * 7);
        //cookie2.setMaxAge(0); //1970.1.1 자정으로 지정됨 - 쿠키삭제

        cookie2.setHttpOnly(true); //false: 자바스크립트로 브라우저에서 조회 가능
        //true: 자바스크립트 조회X, 서버쪽에서만 요청을 통한 조회 가능


        response.addCookie(cookie2);
        return "test";
    }
    @GetMapping("/cookie1/test2")
    //값이 없어도 오류가 발생하지 않는다 (required=false)
    public String test2(@CookieValue(name = "key2", defaultValue = "기본값") String key2){
        System.out.printf("key2=%s%n",key2);
        return "test";

    }
    @GetMapping("/session/test1")
    public String test3(HttpSession session){
        session.setAttribute("key1", "value1");

        return "test";
    }
    //조회하는 메서드
    @GetMapping("/session/test2")
    public String test4(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String value = (String)session.getAttribute("key1");
        System.out.printf("key1=%s%n", value);
        return "test";

    }
}
