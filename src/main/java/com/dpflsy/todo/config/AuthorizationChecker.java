package com.dpflsy.todo.config;

import com.dpflsy.todo.domain.Member;
import com.dpflsy.todo.domain.MemberRole;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthorizationChecker {
    // 해당 URL에 대한 권한이 있는지 체크
    public boolean check(HttpServletRequest request, Authentication authentication) {
        Object principalObj = authentication.getPrincipal();

        // 멤버 여부
        if(!(principalObj instanceof Member)) {
            return false;
        }
        Member member = (Member) authentication.getPrincipal();

        // 권한 URL 확인
//        for (MemberRole role : member.getRoles()) {
//            if(new AntPathMatcher().match(role.getUrl(), request.getRequestURI())) {
//                return true;
//
//            }
//        }

        return false;
    }
}
