package org.choongang.jpaex;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex02Test {
    @PersistenceContext //@Autowired와 같지만..더 명확한 의미를 나타냄
    private EntityManager em;
    @Test
    void test1() {
        Member member = new Member();
        member.setEmail("user01@test.org");
        member.setName("사용자01");
        member.setPassword("12345678");
       // member.setCreatedAt(LocalDateTime.now());

        em.persist(member); //멤버가 영속성 상태에 있게 되고, Member에서  @GeneratedValue 설정해줬기 때문에 증감번호가 자동 추가될 것임
        em.flush();
        em.clear();

        member = em.find(Member.class, member.getSeq()); //쿼리 다시 수행?

        System.out.println(member);
        //수정도 잘 시간이 기록되는지 보기?
        try {
            Thread.sleep(3000); //3초뒤로 실행 설정
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        member.setName("(수정)사용자01");
        em.flush();
        em.clear(); //영속성 제거 -> 쿼리 수행

        member = em.find(Member.class, member.getSeq());
        System.out.println(member);
    }

    @Test
    void test2(){
        Member member = new Member();
        member.setEmail("user01@test.org");
        member.setName("사용자01");
        member.setPassword("12345678");

        em.persist(member);
        em.flush();

        System.out.println(member);

        System.out.printf("createdAt=%s, modifiedAt=%s%n", member.getCreatedAt(), member.getModifiedAt());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        member.setName("(수정)사용자01");
        em.flush();

        System.out.printf("createdAt=%s, modifiedAt=%s%n", member.getCreatedAt(), member.getModifiedAt());

        //System.out.println(member);
    }
}
