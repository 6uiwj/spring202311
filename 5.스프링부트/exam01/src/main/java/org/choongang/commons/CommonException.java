package org.choongang.commons;

import org.springframework.http.HttpStatus;

//응답코드를 상세하게 설정

public class CommonException extends RuntimeException {
    private HttpStatus status;

    //기본적인 오류를 500으로 설정
    public CommonException(String message) {
        this(message, HttpStatus.INTERNAL_SERVER_ERROR); //500
    }

    //status는 500으로 지정, 직접 상태코드 지정할 수 있게
    public CommonException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
