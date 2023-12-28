package configs;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.member.Member;
import org.springframework.web.servlet.HandlerInterceptor;

public class MemberOnlyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //세션 조회
        HttpSession session = request.getSession();
        //회원데이터를 가져와서 있으면 로그인상태, 없으면 아님 (isLogin 메서드 써도 됨)
        //회원 데이터 가져오기
        Member member = (Member)session.getAttribute("member");

        if(member != null) { //로그인 상태 -> 컨트롤러가 실행되면서 페이지를 보여줌?
            return true;
        }
        //비회원 -> 로그인 페이지로 이동

        //response.setStatus(401);
        //보기좋게 상수형태로 입력하자
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        //스프링 컨테이너에서는 redirect를 쓸 수있지만
        //현재 매개변수는 request, response이므로 response.sendredirect를 써야함
        //일단 path 생성
        String url = request.getContextPath() + "/member/login";
        response.sendRedirect(url);

        return false;
    }
}
