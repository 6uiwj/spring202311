package org.choongang.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.choongang.commons.MemberType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity //변화감지의 기준이 될 수 있는 데이터 하나를 의미, getter/setter가 필요

//기본테이블명은 클래스명과 같지만 이 어노테이션을 붙이면 users라는 테이블로 만들어짐?
//가입일자 순으로 내림차순 정렬
//entity 필드명 기준
//1. @EntityListeners(AuditingEntityListener.class) //엔터티 변화감지
//3.
public class Member extends Base {
    
    @Id //기본키(유일성)
    @GeneratedValue //알아서 시퀀스 객체가 만들어짐
    private Long seq;

    @Column(length=80, unique = true, nullable = false)
    private String email;

    @Column(length=40, nullable = false)
    private String name;

    @Column(length=65, nullable = false)
    private String password; //varchar2


    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private MemberType type;

    @ToString.Exclude
    @OneToMany(mappedBy = "member", fetch=FetchType.LAZY) //관계의 주인 명시(자식=외래키) / fetch = ... : 참조발생?
    //조회한 게시글 목록 가져오기
    private List<BoardData> items = new ArrayList<>();


    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="addressNo")
    private Address address;

}
