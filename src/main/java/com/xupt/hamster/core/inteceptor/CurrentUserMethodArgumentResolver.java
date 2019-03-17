
package com.xupt.hamster.core.inteceptor;

import com.xupt.hamster.core.annotation.CurrentUser;
import com.xupt.hamster.core.common.Constants;
import com.xupt.hamster.pojo.Student;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @CurrentUser 注解 解析器
 */
public class CurrentUserMethodArgumentResolver implements CurrentUserMethodArgumentResolverInterface {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(Student.class)
                && parameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        return  (Student) webRequest.getAttribute(Constants.CURRENT_USER, RequestAttributes.SCOPE_REQUEST);
    }
}