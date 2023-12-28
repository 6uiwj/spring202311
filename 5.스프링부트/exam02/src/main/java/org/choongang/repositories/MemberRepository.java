package org.choongang.repositories;

import org.choongang.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

//CRUD가능... + jpa에 맞는 특정 메서드 추가
//JpaRepository<Entity class, 기본키>
public interface MemberRepository extends JpaRepository<Member, Long> {
    //이메일로 조회
    Member findByEmail(String email);

}
