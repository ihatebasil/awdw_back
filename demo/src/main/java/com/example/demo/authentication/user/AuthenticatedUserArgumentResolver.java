package com.example.demo.authentication.user;

import com.example.demo.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
@RequiredArgsConstructor
public class AuthenticatedUserArgumentResolver implements HandlerMethodArgumentResolver {
    private final AuthenticationContext authenticationContext;

    @Override
    public boolean supportsParameter(final MethodParameter parameter) {
        return parameter.hasParameterAnnotation(AuthenticatedUser.class);
    }

    @Override
    public Users resolveArgument(final MethodParameter parameter,
                                 final ModelAndViewContainer mavContainer,
                                 final NativeWebRequest webRequest,
                                 final WebDataBinderFactory binderFactory) {
        return authenticationContext.getPrincipal();
    }
}
