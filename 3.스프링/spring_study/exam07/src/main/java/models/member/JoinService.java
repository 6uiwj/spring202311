package models.member;

import controllers.member.RequestJoin;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final MemberDao memberDao;

    //데이터가 넘어오면 데이터를 바탕으로 DB쪽에 넘길 수 있게 처리하자.
    public void join(RequestJoin form) {
        //plaintext 비번을 입력한 후 salt로 몇번 반복해서 해시를 만들건지 설정할 것(=gensalt)
        String hash = BCrypt.hashpw(form.getUserPw(), BCrypt.gensalt(12));

        Member member = Member.builder()
                .userId(form.getUserId())
                .userPw(hash)
                .userNm(form.getUserNm())
                .email(form.getEmail())
                .build();

        memberDao.register(member);
    }
}
