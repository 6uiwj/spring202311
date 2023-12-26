package org.choongang.jpaex;

import org.choongang.entities.BoardData;
import org.choongang.repositories.BoardDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.domain.Sort.Order.asc;
import static org.springframework.data.domain.Sort.Order.desc;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
@Transactional //test할 때만 있고 제거
public class Ex04Test {

    @Autowired //이미 컨테이너에 담겨있으므로 Autowired를 통해 주입하면 됨..????
    private BoardDataRepository repository;

    @BeforeEach
    void init() {
        List<BoardData> items = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            BoardData item = new BoardData();
            item.setSubject("제목" + i);
            item.setContent("내용" + i);
            items.add(item); //
        }
        repository.saveAllAndFlush(items);
    }


    //Like형태의 쿼리
    @Test
    void test1() {
        //List<BoardData> items = repository.findBySubjectContaining("목");
        List<BoardData> items = repository.findBySubjectContainingOrderBySeqDesc("목");

        items.forEach(System.out::println);
    }

    @Test
    void test2() {
        //Pageable pageable = PageRequest.of(0,3, Sort.by(Sort.Order.desc("createdAt")));
        //이렇게 축약해서 쓸 수도 있음
        Pageable pageable = PageRequest.of(0,3, Sort.by(desc("createdAt"), asc("seq")));
        Page<BoardData> data = repository.findBySubjectContaining("목", pageable);

        List<BoardData> items = data.getContent();
        items.forEach(System.out::println);
    }
}
