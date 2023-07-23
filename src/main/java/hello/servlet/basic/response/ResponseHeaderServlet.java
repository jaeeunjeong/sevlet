package hello.servlet.basic.response;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    // status-line
    resp.setStatus(HttpServletResponse.SC_OK);

    // response-header
    resp.setHeader("Content-Type", "text/plain;charset=utf-8");
    resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    resp.setHeader("Pragma", "no-cache");
    resp.setHeader("my-header", "hello");

    content(resp);
    cookie(resp);
    redirect(resp);

    PrintWriter writer = resp.getWriter();
    writer.println("ok");
  }

  /*
   * 편의 메서드 - content
   */
  private void content(HttpServletResponse response) {
    response.setContentType("text/plain");
    response.setCharacterEncoding("utf-8");
  }

  /*
   * 편의 메서드 - cookie
   */
  private void cookie(HttpServletResponse response) {
    Cookie cookie = new Cookie("myCookie", "hello cookie");
    cookie.setMaxAge(600);
    response.addCookie(cookie);
  }

  /*
   * 편의 메서드 - redirect
   */
  private void redirect(HttpServletResponse response) throws IOException {
    response.sendRedirect("/basic/hello-form.html");
  }
}
