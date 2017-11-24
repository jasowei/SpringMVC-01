package com.lanou.Interceptor;

import com.lanou.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dllo on 17/11/10.
 */
public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        String uri = request.getRequestURI();
        if (uri.indexOf("login") != -1 || uri.indexOf("register") != -1){
            return true;
        }
        User user = (User) request.getServletContext().getAttribute("loginUser");
        if (user == null){
            request.getRequestDispatcher("/WEB-INF/pages/user/login.jsp").forward(request,response);
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
