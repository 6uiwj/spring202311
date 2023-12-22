package mapper;

import controllers.admin.MemberSearch;
import models.member.Member;

import java.util.List;

//mapper에 추가했던 id가 method의 명칭과 동일하면.......
public interface MemberMapper {
    int register(Member member);
    int exist(String userId);
    Member get(String userId);

    List<Member> getList(MemberSearch search);
}
