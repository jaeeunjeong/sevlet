package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 1. 파라미터 전송 기능 -> get/ post 둘다 호환 가능함.
 * x-www-from-urlencoded로 되어 있으면
 * post 방식이어도 get 방식처럼 쿼리 파라미터처럼 보내줘서
 * 동일하게 getParameter() 메서드를 사용한다.
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

        System.out.println("=== 단일 중복 파라미터 조회 start ===");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username : " + name);
        }
        System.out.println("=== 단일 중복 파라미터 조회 end ===");
    }
}
