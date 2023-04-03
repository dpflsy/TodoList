package com.dpflsy.todo.service;

import com.dpflsy.todo.domain.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuService {
    private List<Menu> menus = new ArrayList<>();

    // 메뉴 추가
    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    // 전체 메뉴를 가져온다
    public List<Menu> getMenus() {
        return menus;
    }
}

