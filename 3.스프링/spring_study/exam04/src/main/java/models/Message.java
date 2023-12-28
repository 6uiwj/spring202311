package models;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Message implements InitializingBean, DisposableBean {
    public void send(String message) {
        System.out.printf("전송 메시지 : %s%n", message);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //초기화 단계에서 호출, 실행
        System.out.println("afterPropertiesSet()!!!!");

    }

    @Override
    public void destroy() throws Exception {
        //스프링 컨테이너에 있는 빈 소멸 전 호출
        //자원 해제를 주로 많이 처리
        System.out.println("destroy()!!!");
    }
}
