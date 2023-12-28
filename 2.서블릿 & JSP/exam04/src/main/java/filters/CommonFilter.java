package filters;

        import jakarta.servlet.*;
        import jakarta.servlet.http.HttpServletRequest;

        import java.io.IOException;

public class CommonFilter implements Filter {
    //공통으로 적용할 부분을 정의해줄 것입니다.
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request,response);
        chain.doFilter(new CommonRequestWrapper((HttpServletRequest) request), response);
    }

}
