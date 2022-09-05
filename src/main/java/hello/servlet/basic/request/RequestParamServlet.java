package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 1. 파라미터 전송 기능
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("=== 전체 파라미터 조회 start ===");
        Enumeration<String> parameterNames = request.getParameterNames(); // java 8은 안되는 듯하여...
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            System.out.println(paramName + ":" + request.getParameter(paramName));
        }
        System.out.println("=== 전체 파라미터 조회 end ===");

        System.out.println("=== 단일 파라미터 조회 start ===");
        System.out.println("username : " + request.getParameter("username"));
        System.out.println("age : " + request.getParameter("age"));
        System.out.println("=== 단일 파라미터 조회 end ===");

        System.out.println("=== 단일 중복 파라미터 조회 end ===");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username : " + name);
        }
        System.out.println("=== 단일 중복 파라미터 조회 end ===");
    }
}
