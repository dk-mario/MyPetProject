package ru.sberbank.jpafinalproject.configs;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

import static ru.sberbank.jpafinalproject.entity.RoleType.CUSTOMER;
import static ru.sberbank.jpafinalproject.entity.RoleType.SPECIALIST;

@Component
public class SuccessUserHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains(SPECIALIST.getName())) {
            httpServletResponse.sendRedirect("/specialist");
        } else if (roles.contains(CUSTOMER.getName())) {
            httpServletResponse.sendRedirect("/customer");
        } else {
            httpServletResponse.sendRedirect("/");
        }
    }
}

