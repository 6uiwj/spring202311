package org.choongang.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity //변화감지의 기준이 될 수 있는 데이터 하나를 의미, getter/setter가 필요
public class Member {
    @Id
    private Long seq;
    private String email;
    private String name;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
