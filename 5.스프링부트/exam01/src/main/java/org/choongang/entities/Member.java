package org.choongang.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data @Builder //@Builder : 기본생성자가 private으로 들어감
@NoArgsConstructor @AllArgsConstructor //이 두가지를 같이 추가하면 Builder에 기본생성자가 편법으로 사용 가능하게 추가된대...
public class Member {
    //USER_NO -> userNo
    //기본키임을 알려주자 @Id
    @Id
    private Long userNo;
    private String userId;
    @JsonIgnore
    private String userPw;
    private String userNm;
    private String email;

    @JsonFormat(pattern="yyyy.MM.dd HH:mm")
    private LocalDateTime regDt;

    @JsonFormat(pattern="yyyy.MM.dd HH:mm")
    private LocalDateTime modDt;
}
