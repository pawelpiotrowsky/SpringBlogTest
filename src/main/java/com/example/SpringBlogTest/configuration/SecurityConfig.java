package com.example.SpringBlogTest.configuration;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.persistence.*;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;


@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/h2/console").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/profile").hasAnyRole("ADMIN", "USER")
                .antMatchers("/post/{id}/**").permitAll()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .usernameParameter("email")
                .passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/").invalidateHttpSession(true).deleteCookies("JSESSIONID")
                .and()
                .csrf().disable()
                .headers().frameOptions().disable();

        private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
   ...
   .formLogin()
                .loginPage("/login")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                        Authentication authentication) throws IOException, ServletException {
                        redirectStrategy.sendRedirect(request, response, "/");
                    }
                }
    }
}