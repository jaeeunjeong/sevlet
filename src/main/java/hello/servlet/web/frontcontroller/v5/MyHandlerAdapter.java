package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.v2.ModelView;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MyHandlerAdapter {

  boolean supports(Object handler);

  ModelView handler(HttpServletRequest request, HttpServletResponse response,
      Object object) throws ServletException;

}
