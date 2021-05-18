package com.example.SpringBlogTest.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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
    }
}
