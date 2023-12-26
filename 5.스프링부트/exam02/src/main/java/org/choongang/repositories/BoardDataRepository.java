package org.choongang.repositories;

import org.choongang.entities.BoardData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardDataRepository extends JpaRepository<BoardData, Long> {
    //메서드 패턴 만들기
    //List<BoardData> findBoardData... //이미 지네릭 클래스로 명시가 되어있기 때문에(JpaRepository<BoardData, Long> ) 굳이 안써줘도 됨
    List<BoardData> findBySubjectContaining(String keyword);
    Page<BoardData> findBySubjectContaining(String keyword, Pageable pageable);

    //seq에 따른 내림차순 정렬조건 넣어주기
    List<BoardData> findBySubjectContainingOrderBySeqDesc(String keyword);

}
