package models.member;

import controllers.admin.MemberSearch;
import lombok.RequiredArgsConstructor;
import mapper.MemberMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

//자동스캔 대상으로 지정해주자.
@Repository
@RequiredArgsConstructor
public class MemberDao {
    //의존성 추가 - 선생님은 AutoWired를 싫어한대~ 다른 방법을 쓰시겠대~
    //final을 선언하고 @RequiredArgsConstructor 붙이기
    //final을 붙이면 상수이므로 혹시라도 바꿀 필요가 있다면 final 떼고 @NonNull 애너테이션 붙이기
    private final MemberMapper mapper;

    public boolean register(Member member) {
        //레코드 개수 반환
        int affectedRows = mapper.register(member);
        return affectedRows > 0;
    }


    //아이디가 존재하는지 여부를 확인하는 메서드(결과값이 1개 이상인가?)
    public boolean exist(String userId) {
        int cnt = mapper.exist(userId);
        //1개 이상 나오는지(존재여부) 체크
        return cnt > 0; // 1이상 - 이미 등록된 아이디
    }

    public Member get(String userId) {

        return mapper.get(userId);
    }

    public List<Member> getList(MemberSearch search) {
        LocalDate edate = search.getEdate();
        //edate에 하루를 더해줌
        if(edate != null) {
            LocalDate newEdate = edate.plusDays(1);
            //미만이니까 전날 자정까지 조회됨...?
            search.setEdate(newEdate);
        }
        return mapper.getList(search);

    }

}
