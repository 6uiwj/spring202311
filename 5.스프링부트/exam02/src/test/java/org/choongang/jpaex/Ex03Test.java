package org.choongang.jpaex;

import org.choongang.entities.BoardData;
import org.choongang.repositories.BoardDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex03Test {

    @Autowired
    private BoardDataRepository repository;

    //한꺼번에 모아서 쿼리 실행 , 총10개 추가
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
    @Test
    void test2() {
        //findAll을 사용해보자, select쿼리가 수행됨
        List<BoardData> items = repository.findAll();
        items.forEach(System.out::println);
    }
    @Test
    void test1() {
        BoardData data = new BoardData();
        data.setSubject("제목");
        data.setContent("내용");

        //repository.save(data); //persist(data)
        //repository.flush(); //insert query수행
        data = repository.saveAndFlush(data); //persist(data) + flush() - 변화감지
        //반환값이  영속 상태
        data.setSubject("(수정)제목");
        //repository.saveAndFlush(data);
        //repository.flush();
        repository.save(data); //영속 상태

        //조회할 때는 따로 flush를 않아도 flush가 됨(변경사항이 반영된 후 조회하는 것이 당연하기 때문에...?)
        //조회 실행시 암묵적으로 flsuh()가 먼저 수행 -> 조회
        BoardData data2 = repository.findById(data.getSeq()).orElse(null);  //기본키를 가지고 조회, 값이 없을 경우 null
        System.out.println(data2);
    }
}
