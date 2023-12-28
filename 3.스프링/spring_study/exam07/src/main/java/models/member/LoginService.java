package models.member;

import controllers.member.RequestLogin;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberDao memberDao;
    //조회한 데이터를 세션에 유지하기 위해 세션 생성
    private final HttpSession session;
    
    //회원을 조회해서 로그인 처리
    public void login(RequestLogin form) {
        /**
         * 1. 아이디로 회원 조회
         * 2. 세션에 회원 정보 유지
         */
        //1. 조회
        String userId = form.userId();
        Member member = memberDao.get(userId);
        //2. 세션에 유지
        session.setAttribute("member",member);
    }
    }
