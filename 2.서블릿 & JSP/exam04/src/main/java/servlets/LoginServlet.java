package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebServlet("/member/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/templates/member/login.jsp");
        rd.forward(req, resp);
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init()!!!");
        String key1 = config.getInitParameter("key1");
        String key2 = config.getInitParameter("key2");
        System.out.printf("key1=%s, key2=%s%n", key1, key2);
    }
    @Override
    public void destroy() {
        System.out.println("destroy()!!!");
    }



}
