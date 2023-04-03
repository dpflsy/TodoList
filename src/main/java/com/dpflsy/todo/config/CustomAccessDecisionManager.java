package com.dpflsy.todo.config;

import com.dpflsy.todo.domain.Menu;
import com.dpflsy.todo.service.MenuService;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        // 사용자가 가지고 있는 권한 목록을 조회합니다.
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        // 메뉴 정보를 조회합니다.
        MenuService m = new MenuService();
        List<Menu> menus = m.getMenus();

        // 권한에 따라 접근 가능한 메뉴를 필터링합니다.
        List<Menu> allowedMenus = menus.stream()
                .filter(menu -> {
                    // 메뉴에 지정된 권한과 사용자가 가지고 있는 권한 중에서 일치하는 권한이 있는 경우 true를 반환합니다.
                    return menu.getAuth().stream()
                            .anyMatch(authority -> authorities.stream().anyMatch(a -> a.getAuthority().equals(authority)));
                })
                .collect(Collectors.toList());

        // 접근 권한이 없는 메뉴가 있다면 예외를 발생시킵니다.
        if (allowedMenus.isEmpty()) {
            throw new AccessDeniedException("Access is denied");
        }
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
