package filters;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.util.Objects;

public class CommonRequestWrapper extends HttpServletRequestWrapper {



    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request the {@link HttpServletRequest} to be wrapped.
     * @throws IllegalArgumentException if the request is null
     */
    public CommonRequestWrapper(HttpServletRequest request) {
        super(request);
        //요청시 공통 처리 부분
        request.setAttribute("siteConfig","사이트 설정...");

    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);

        value = value==null? value : value.toUpperCase();

        return value;
    }
}
