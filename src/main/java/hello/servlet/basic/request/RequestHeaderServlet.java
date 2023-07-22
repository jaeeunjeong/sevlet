package hello.servlet.basic.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    printStartLine(request);
  }

  private static void printStartLine(HttpServletRequest request) {
    System.out.println("--- REQUEST LINE START ---");
    System.out.println("request.getMethod() = " + request.getMethod());
    System.out.println("request.getProtocol() = " + request.getProtocol());
    System.out.println("request.getScheme() = " + request.getScheme());
    System.out.println("request.getRequestURL() = " + request.getRequestURL());
    System.out.println("request.getRequestURI() = " + request.getRequestURI());
    System.out.println("request.getQueryString() = " + request.getQueryString());
    System.out.println("request.isSecure() = " + request.isSecure());
    System.out.println("--- REQUEST LINE END ---");
  }

  private static void printHeaderName(HttpServletRequest request) {
    System.out.println("--- Headers START ---");

    request.getHeaderNames() .asIterator()
        .forEachRemaining(headerName -> System.out.println(headerName + ":" + headerName));

    System.out.println("--- Headers END---");
  }
}
