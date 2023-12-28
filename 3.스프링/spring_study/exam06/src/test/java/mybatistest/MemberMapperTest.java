package mybatistest;

import config.AppCtx;
import mapper.MemberMapper;
import models.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppCtx.class)
public class MemberMapperTest {
    //이미 위에서 컨테이너는 만들어져 있으므로 바로 의존성 주입
    @Autowired
    private MemberMapper mapper;

    @Test
    @DisplayName("회원 목록 조회 테스트")
    void memberListTest() {
        Member member = Member.builder()
                .userId("USER")
                .userNm("사용자")
                .build();

        List<Member> members = mapper.getMembers(member);

        for(Member m : members) {
            System.out.println(m);
        }
        System.out.println(mapper.getClass().getName());

    }

    @Test
    @DisplayName("회원 추가 테스트")
    void memberInsertTest() {
        Member member = Member.builder()
                .userId("USER203")
                .userPw("123456")
                .userNm("사용자203")
                .email("user203@test.org")
                .build();
        int affectedRow = mapper.register(member);
        System.out.println(affectedRow);
        System.out.println(member);
    }
    @Test
    @DisplayName("회원정보 수정 업데이트")
    void memberUpdateTest(){
        Member member = Member.builder()
                .userId("USER99")
                .userPw("(수정)123456")
                .userNm("(수정)사용자99")
                .email("(수정)user99@test.org")
                .build();

        int affectedRows = mapper.update(member);
        System.out.println(affectedRows);

    }
    @Test
    @DisplayName("회원 삭제 테스트")
    void memberDeleteTest() {
        int affectedRows = mapper.delete("USER99");
        System.out.println(affectedRows);

    }
}
