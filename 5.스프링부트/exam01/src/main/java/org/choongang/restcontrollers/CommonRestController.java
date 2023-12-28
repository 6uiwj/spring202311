package org.choongang.restcontrollers;

import org.choongang.commons.CommonException;
import org.choongang.commons.JSONData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//json은 restController에서 받도록?
@RestControllerAdvice("org.choongang.restcontrollers")
public class CommonRestController {
    //응답코드를 상세하게 설정할 수있게 만들어 줬떤 CommonException

    @ExceptionHandler(Exception.class)
    public ResponseEntity<JSONData> errorHandler(Exception e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; //500
        //e의 객체가 CommonException으로부터 온 에러인가?
        //우리가 던진 예외이면 우리가 설정한 status를 가져온다?
        if(e instanceof CommonException){
            CommonException commonException = (CommonException) e;
            status = commonException.getStatus();
        }

        e.printStackTrace();

        JSONData<Object> data = new JSONData<>();
        //상태코드
        data.setStatus(status);
        data.setMessage(e.getMessage());
        data.setSuccess(false);

        return ResponseEntity.status(status).body(data);
    }
}
