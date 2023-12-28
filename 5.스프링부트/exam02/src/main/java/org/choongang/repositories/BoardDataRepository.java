package org.choongang.repositories;

import org.choongang.entities.BoardData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardDataRepository extends JpaRepository<BoardData, Long>, QuerydslPredicateExecutor<BoardData> {
    //Fecth조인


    //메서드 패턴 만들기
    //List<BoardData> findBoardData... //이미 지네릭 클래스로 명시가 되어있기 때문에(JpaRepository<BoardData, Long> ) 굳이 안써줘도 됨
    @EntityGraph(attributePaths = {"member"}) //설정값 중 항목을 명시하면 됨
    List<BoardData> findBySubjectContaining(String keyword);
    Page<BoardData> findBySubjectContaining(String keyword, Pageable pageable);

    //seq에 따른 내림차순 정렬조건 넣어주기
    List<BoardData> findBySubjectContainingOrderBySeqDesc(String keyword);
    //위의 쿼리와 동일
    @Query("SELECT b FROM BoardData b LEFT JOIN FETCH b.member WHERE b.subject LIKE %:key% ORDER BY b.seq DESC" ) //(JPQL형태의 쿼리)
    List<BoardData> getSubjects(@Param("key") String keyword);

    @Query("SELECT b FROM BoardData b WHERE b.subject LIKE %:key%")
    Page<BoardData> getSubjects(@Param("key") String keyword, Pageable pageable);
}
