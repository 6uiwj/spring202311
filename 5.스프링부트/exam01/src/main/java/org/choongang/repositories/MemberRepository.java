package org.choongang.repositories;

import org.choongang.entities.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends CrudRepository<Member, Long> {
    //매개변수로 들어가 있어서 Member entity인게 명확하므로 fineMember > find라고만 써도 됨
    //fineMemberByUserId > findByUserId
    Member findByUserId(String userId);

    //like를 이용하여 포함조건으로 쿼리수행
    //List<Member> findByUserNmContaining(String keyword);\
    //정렬 추가
    //List<Member> findByUserNmContainingOrderByRegDtDesc(String keyword);
    List<Member> findByUserNmContainingOrUserIdContainingOrderByRegDtDesc(String keyword1, String keyword2);

    Page<Member> findByUserNmContaining(String key, Pageable pageable);


    //복잡한 쿼리는 직접 작성하는게 나을지도....
    //:~ 변수로써 교체될 수 있는 부분?
    @Query("SELECT * FROM MEMBER WHERE USER_NM LIKE '%:key1%' OR USER_ID LIKE '%:key2%' ORDER BY REG_DT DESC")
    List<Member> getMembers(@Param("key1") String keyword1, @Param("key2") String keyword2);
}
