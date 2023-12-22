<%@ page contentType="text/html; charset=UTF-8"%>
<%
    //_jspService 지역 내부에 변수선언 됨
    //response.sendRedirect("ex03.jsp");
    out.write("<h1>ex02.jsp");
%>
<%!

// 여기엔 out쓰면 안됨 _jspservice 영역 밖에서 번역되기 때문에
// 표현 문에서는 내장 객체 접근 불가
%>