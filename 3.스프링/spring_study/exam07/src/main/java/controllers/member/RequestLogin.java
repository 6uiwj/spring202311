package controllers.member;

import jakarta.validation.constraints.NotBlank;

//값이 상수로 되어있어서 한번 설정하면 변경이 불가
public record RequestLogin(
        @NotBlank
        String userId,
        @NotBlank
        String userPw
) {}
