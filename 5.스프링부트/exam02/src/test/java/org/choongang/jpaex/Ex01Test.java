package org.choongang.jpaex;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.entities.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Transactional
//테스트 환경에서 사용되는 프로퍼티 소스를 지정
@TestPropertySource(properties= "spring.profiles.active=test") //application.test.yml이 설정파일로 들어간다.
public class Ex01Test {
    @PersistenceContext //Autowired와 동일한데 jpa에 적합한 녀석?
    private EntityManager em;

    /*
    //회원정보를 미리 넣어줌?
    @BeforeEach
    void init() {
        Member member = new Member();
        member.setSeq(1L);
        member.setEmail("user01@test.org");
        member.setName("사용자01");
        member.setPassword("12345678");
        member.setCreatedAt(LocalDateTime.now());

        em.persist(member);
        em.flush();
        em.clear(); //영속 상태 엔터티 모두 비우기

    }

     */
    @Test
    void test1() {
        Member member = new Member();
        member.setSeq(1L);
        member.setEmail("user01@test.org");
        member.setName("사용자01");
        member.setPassword("12345678");
        member.setCreatedAt(LocalDateTime.now());

        //영속성 컨텍스트(상태변화감지 메모리) 안에 넣어주자
        em.persist(member); //영속성 컨텍스트에 영속상태 - 변화 감지 시작
        em.flush();

     //   em.detach(member); //영속성 분리 -변화감지X

       // member.setName("(수정)사용자01");
       // em.flush();

       // em.merge(member); //분리된 영속 상태 엔터티 -> 영속 상태로 만듦: 변화감지O
       // em.flush();
        //em.remove(member); //제거 상태로 변경
        //em.flush();
    }
    //조회

    @Test
    void test2() {
        //find : 기본키를 가지고 조회
        Member member = em.find(Member.class, 1L);
        System.out.println(member);
        //이 쿼리는 수행되지 않을 것임 (이미 있는 데이터를 그대로 가져옴
        Member member2 = em.find(Member.class, 1L);
        System.out.println(member2);
    }


    @Test
    void test3() {
        List<Member> members = em.createQuery("SELECT m FROM Member m", Member.class)
                .getResultList();
        members.forEach(System.out::println);
    }
}
