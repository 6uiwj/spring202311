package controllers.member;

import lombok.RequiredArgsConstructor;
import models.member.MemberDao;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

//기본스캔대싱임을 알려주는 스프링 관리객체 Bean으로 등록
@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator {

    private final MemberDao memberDao;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestJoin.class);
    }

    /**
     * 실제로 검증을 수행할 메서드
     * @param target the object that is to be validated
     * @param errors contextual state about the validation process
     */

    @Override
    public void validate(Object target, Errors errors) {
        /**
         * 1. 필수 항목 검증(userId, userPw, confirmPw, userNm, agree) - O
         * 2. 중복 아이디 여부 체크
         * 3. 아이디 최소 자리수(6자리 이상) 체크 - O
         * 4. 비밀번호 최소 자리수(8자리 이상) 체크 - O
         * 5. 이메일 값은 필수는 아니지만 값이 있으면 형식 체크 - O
         * 6. 비밀번호, 비밀번호 확인 일치여부
         */

        //2번 6번 처리하자
        RequestJoin form = (RequestJoin)target;

        //중복 아이디 여부 체크
        String userId = form.getUserId();
        //이미 가입된 아이디라면!
        if (StringUtils.hasText(userId) && memberDao.exist(userId)) {
            errors.rejectValue("userId","Duplicated");
        }


        String userPw = form.getUserPw();
        String confirmPw = form.getConfirmPw();

        if(StringUtils.hasText(userPw) && StringUtils.hasText(confirmPw)
                && !userPw.equals(confirmPw)) {
            errors.rejectValue("confirmPw", "Mismatch");

        }
        //커맨드 객체 자체에 문제가 있을때 reject 사용
        // 에러메시지?
        /*
        boolean result = false;
        if(!result) {
            errors.reject("ErrorTest","공통 에러....");
        }

         */

    }
}
