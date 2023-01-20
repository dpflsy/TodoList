package com.dpflsy.todo.domain;

import lombok.Builder;
import lombok.Data;

// Response를 담을 객체
@Data
@Builder
public class Todo {
    private Long id;
    private String item;
    private String isCompleted;
}
