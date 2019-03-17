
package com.xupt.hamster.core.inteceptor;

import com.alibaba.druid.util.StringUtils;
import com.xupt.hamster.core.annotation.AuthIgnore;
import com.xupt.hamster.core.annotation.AuthShare;
import com.xupt.hamster.core.common.Constants;
import com.xupt.hamster.core.enums.HttpCodeEnum;
import com.xupt.hamster.core.utils.TokenUtils;
import com.xupt.hamster.pojo.Student;
import com.xupt.hamster.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private StudentService studentService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod handlerMethod = null;
        try {
            handlerMethod = (HandlerMethod) handler;
        } catch (Exception e) {
            response.setStatus(HttpCodeEnum.NOT_FOUND.getCode());
            return false;
        }
        Method method = handlerMethod.getMethod();

        AuthIgnore ignoreAuthMethod = method.getAnnotation(AuthIgnore.class);
        //注解不需要验证token
        if (handler instanceof HandlerMethod && null != ignoreAuthMethod) {
            return true;
        }

        String token = request.getHeader(Constants.TOKEN_HEADER_STRING);

        AuthShare authShareMethoed = method.getAnnotation(AuthShare.class);
        if (handler instanceof HandlerMethod && null != authShareMethoed) {
            if (!StringUtils.isEmpty(token) && token.startsWith(Constants.TOKEN_PREFIX)) {
                String username = tokenUtils.getUsername(token);
                Student student = studentService.getByUserName(username);
                request.setAttribute(Constants.CURRENT_USER, student);
            }
            return true;
        }

        if (StringUtils.isEmpty(token) || !token.startsWith(Constants.TOKEN_PREFIX)) {
            log.info("{} : Unknown token", request.getServletPath());
            response.setStatus(HttpCodeEnum.FORBIDDEN.getCode());
            response.getWriter().print("The resource requires authentication, which was not supplied with the request");
            return false;
        }
        String username = tokenUtils.getUsername(token);
        Student student = studentService.getByUserName(username);
        if (null == student) {
            log.info("{} : token student not found", request.getServletPath());
            response.setStatus(HttpCodeEnum.FORBIDDEN.getCode());
            response.getWriter().print("ERROR Permission denied");
            return false;

        }
        if (!tokenUtils.validateToken(token, student)) {
            log.info("{} : token validation fails", request.getServletPath());
            response.setStatus(HttpCodeEnum.FORBIDDEN.getCode());
            response.getWriter().print("Invalid token ");
            return false;
        }
        request.setAttribute(Constants.CURRENT_USER, student);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
