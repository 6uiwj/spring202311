package org.choongang.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class BoardData extends Base {
    @Id
    @GeneratedValue
    private Long seq;

    @Column(length=100, nullable = false)
    private String subject;

    @Lob
    @Column(nullable = false)
    private String content;

    //주인쪽으로 명시하는 항목?
    @ManyToOne(fetch=FetchType.LAZY) //join, 외래키 생성
    @JoinColumn(name="userNo")
    private Member member;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<HashTag> tags = new ArrayList<>();
}
