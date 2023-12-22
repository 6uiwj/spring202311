package org.choongang.commons;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


//응답 통일된 형식의 틀 만들어주기
//응답데이터가 뭐가 올지 모르니 지네릭 형태로 받는다. 이렇게 안받아도됨.. toString...어쩌구...
@Data
@NoArgsConstructor
@RequiredArgsConstructor //바로 생성자 생성
public class JSONData<T> {
    //성공 시 true
    private boolean success = true;
    private HttpStatus status = HttpStatus.OK; // 응답 상태 코드 - 200이 제일 많이 나오니까 일단 200으로 고정
    //setter로 해도 되지만 데이터가 많을 수 있으니까 불편해. 처음 생성할 때부터 생성할 수 있게 해주자.

    @NonNull //생성자 매개변수로 추가
    private T data; //성공시 응답 Body 데이터
    private String message; //실패 시 메시지

}
