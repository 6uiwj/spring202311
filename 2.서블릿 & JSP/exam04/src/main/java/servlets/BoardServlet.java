package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class BoardServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        //resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<form method='post' action ='/exam04/board'>");
        out.println("취미 : <input type ='checkbox' name='hobby' value='취미1'>취미1");
        out.println("<input type ='checkbox' name='hobby' value='취미2'>취미2");
        out.println("<input type ='checkbox' name='hobby' value='취미3'>취미3");
        out.println("<input type ='checkbox' name='hobby' value='취미4'>취미4<br>");

        out.println("제목 : <input type='text' name='subject'><br>");
        out.println("내용 : <textarea name='content'></textarea><br>");
        out.println("<button type='submit'>작성하기</button>");
        out.println("</form>");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String subject = req.getParameter("subject");
        String content = req.getParameter("content");
        String[] hobby = req.getParameterValues("hobby");


        System.out.printf("subject=%s, content=%s%n", subject, content);
        System.out.printf("hobby=%s%n", Arrays.toString(hobby));
    }
}
