package commons;

import org.springframework.http.HttpStatus;

//RuntimeException : 모든 예외의 상위클래스로 설정
public class CommonException extends RuntimeException{
    //HttpStatus = enum class의 상수
    private HttpStatus status;
    public CommonException(String message) {
        //기본적인 에러는 500코드로 고정하고 상태 코드는 바꿀 수 있게 설정?
        this(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public CommonException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
