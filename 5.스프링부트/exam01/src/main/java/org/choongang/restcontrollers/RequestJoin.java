package org.choongang.restcontrollers;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

//회원 요청 데이터를 설정할 커맨드 객체
@Data
public class RequestJoin {
    //@NotBlank로 필수항목 검증작업
    @NotBlank(message="아이디를 입력하세요.")
    private String userId;

    @NotBlank(message="비밀번호를 입력하세요.")
    private String userPw;

    @NotBlank(message="비밀번호를 확인하세요.")
    private String confirmPw;

    @NotBlank(message="회원명을 입력하세요.")
    private String userNm;
    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDt;
}
