package controllers.member;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class RequestJoin {
    //필수이다!!
    @NotBlank//(message = "아이디를 입력하세요.")
    @Size(min=6)
    private String userId;

    @NotBlank
    @Size(min=8)
    private String userPw;

    @NotBlank
    private String confirmPw;

    @NotBlank
    private String userNm;

    @Email
    private String email;

    @AssertTrue
    private boolean agree;
}
