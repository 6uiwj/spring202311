package controllers.member;

import commons.CommonException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//컨트롤러에만 적용되도록 범위 설정해주자. "controllers" 입력
@ControllerAdvice("controllers")
public class CommonController {
    //응답코드를 내보내기위해 response 객체 매개변수로 받는다.
    @ExceptionHandler(Exception.class)
    public String errorHandler(Exception e, Model model, HttpServletResponse response) {
        //기본예외를 500으로 고정
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; //500
        //우리가 정의한 예외이면 우리가 직접 정의한 예외코드를 출력?
        if(e instanceof CommonException) {
            CommonException commonException = (CommonException)e;
            //우리가 정의한 응답코드 가져오기
            status = commonException.getStatus();
        }
        //response 객체에 우리가 정의한 응답코드 담기?
        response.setStatus(status.value());

        e.printStackTrace();
        //사용자 쪽에 보낼 메시지 정의
        model.addAttribute("message", e.getMessage());


        return "error/common";
    }
}
