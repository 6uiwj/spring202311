package configs;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class CommonInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //model이 없으니까 request.setAttribute 이용
        //사이트 전역에 유지될 값 정의
        request.setAttribute("commonValue", "공통 값...");



        //공통값만  처리할 거니까 true
        return true;
    }
}
