package com.dpflsy.todo.service;

import com.dpflsy.todo.domain.Todo;
import com.dpflsy.todo.mapper.TodoMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class TodoServiceTest {

    @Autowired
    private TodoMapper todoMapper;
    private static final Long testId = 1L;
    @Test
    @DisplayName("todoList 전체 조회해보기")
    void getTodoList() {
        // 전체 조회해보기
        List<Todo> todoList = todoMapper.getTodoList();
        assertThat(todoList.size() > 0);
    }

    @Test
    @DisplayName("todoList 단건 조회해보기")
    void getOneTodoList() {
        // 단건 조회해보기
        List<Todo> todoOneList = todoMapper.getOneTodoList(testId);
        String testItem = "스프링부트 공부하기";
        String testBoolean = "Y";
        System.out.println(testItem);
        assertThat(testItem.equals(todoOneList.get(0).getItem()));
        assertThat(testBoolean.equals(todoOneList.get(0).getIsCompleted()));
    }
}