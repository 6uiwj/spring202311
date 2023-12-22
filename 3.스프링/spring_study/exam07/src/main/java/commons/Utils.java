package commons;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import models.member.Member;
import org.springframework.beans.factory.annotation.Autowired;

public class Utils {
    //세션을 조회에서 로그인 정보를 가져온다.
    @Autowired
    private HttpSession session;
    //세션에 담겨있는 멤버 정보를 가져올 수있는 편의 기능

    //로그인 했는지 안했는지 확인 (세션에 값이 있는가?)
    public boolean isLogin() {
        return getMember() != null;
    }


    public Member getMember() {
        Member member = (Member) session.getAttribute("member");

        return member;
    }
}
