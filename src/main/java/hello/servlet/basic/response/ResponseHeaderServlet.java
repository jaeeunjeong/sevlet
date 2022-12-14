package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {


    private HttpServletResponse response;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // status-line
        response.setStatus(HttpServletResponse.SC_OK);

        // response-header
        response.setHeader("Content-type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello");

        // 헤더 편의 메서드
//        content(response);

        // 쿠키 편의 메서드
//        cookie(response);

        // 리다이렉트 편의 메서드
        redirect(response);

        PrintWriter writer = response.getWriter();
        writer.write("ok");
    }

    private void content(HttpServletResponse response) {
//        response.setHeader("Content-type", "text/plain;charset=utf-8");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
//        response.setContentLength(5); // 생략하면 자동으로 생성됨.
    }

    private void cookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException {

        response.setHeader("Content-type", "text/plain;charset=utf-8");
        response.sendRedirect("/basic/hello-form.html");
    }
}
