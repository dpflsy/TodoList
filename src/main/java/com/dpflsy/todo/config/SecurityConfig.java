package com.dpflsy.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
* 권한 모듈을 작동시킴
**/
// @Order(1)    // 여러개의 SecurityFilterChain이 있을 때 순서가 중요함 -> 순서를 정하는 어노테이션
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 필요한 Bean(Filter들) 생성
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(User.builder()
                        .username("user2")
                        .password(passwordEncoder().encode("2222"))
                        .roles("USER")
                ).withUser(User.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("3333"))
                        .roles("ADMIN"))
        ;
    }

    // 패스워드 암호화
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // 특정페이지만 열어둔다
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
        // 특정 request에 대해 filterchain이 동작할 것인지 설정
        http.antMatcher("/api/**");
        */

        // 메인페이지는 열어두고 싶을 때 ("/") - 화이트리스트
        http.authorizeRequests((requests) ->
                requests.antMatchers("/").permitAll()
                        .anyRequest().authenticated());
        http.formLogin();
        http.httpBasic();

        /*
        // filter를 사용하고 싶지 않을 때
        http
                .headers().disable()
                .csrf().disable()
                .logout().disable()
                .requestCache().disable()
        ;
         */
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
