<%@ page contentType="text/html; charset=UTF-8" %>
<h1>안녕하세요!</h1>

<%
    int num1 = 100;
    int num2 = 100;
    int result = add(num1, num2);

%>

<%=result%>
<%!
    int num3 = 300;

        int add(int num1, int num2){
            return num1 + num2;
        }
%>