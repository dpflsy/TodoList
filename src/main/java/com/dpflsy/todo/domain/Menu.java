package com.dpflsy.todo.domain;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    // 메뉴명
    private String name;
    // 메뉴 URL
    private String url;
    // 해당 메뉴에 접근할 수 있는 권한 목록
    private List<String> auth;

}
