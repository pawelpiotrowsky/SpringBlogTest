package com.example.SpringBlogTest.bootstrap;

import com.example.SpringBlogTest.repository.UserRepository;
import com.example.SpringBlogTest.service.UserService;
import com.example.SpringBlogTest.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
    public class UserSuccessHandler implements AuthenticationSuccessHandler {

    private final User user;

        private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public UserSuccessHandler(UserRepository userRepository, UserService userService, User user) {
        this.user = user;}

    @Override
        public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse arg1,
                                            Authentication authentication) throws IOException, ServletException {

            boolean hasUserRole = false;
            boolean hasAdminRole = false;
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority grantedAuthority : authorities) {
                if (user.getRole().equals("USER")) {
                    hasUserRole = true;
                    break;
                } else if (user.getRole().equals("ADMIN")) {
                    hasAdminRole = true;
                    break;
                }
            }

            if (hasUserRole) {
                redirectStrategy.sendRedirect(arg0, arg1, "/");
            } else if (hasAdminRole) {
                redirectStrategy.sendRedirect(arg0, arg1, "/");
            } else {
                throw new IllegalStateException();
            }
        }

    }
