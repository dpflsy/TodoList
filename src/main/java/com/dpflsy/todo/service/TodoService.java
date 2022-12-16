package com.dpflsy.todo.service;

import com.dpflsy.todo.mapper.TodoMapper;
import com.dpflsy.todo.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    @Autowired
    private TodoMapper todoMapper;

    public List<Todo> getTodoList() {
        return todoMapper.getTodoList();
    }

    public List<Todo> getOneTodoList(Long id) {
        return todoMapper.getOneTodoList(id);
    }
    // 할 일을 저장
    public boolean insertTodoList(Todo todo) {
        int queryResult = 0;
        if(todo != null)
            queryResult = todoMapper.insertTodoList(todo);
        return (queryResult == 1) ? true : false;
    }

    // 할 일 수행 여부에 대한 상태 수정
    public boolean updateTodoList(Todo todo) {
        int queryResult = 0;
        if(todo != null)
            queryResult = todoMapper.updateTodoList(todo);
        return (queryResult == 1) ? true : false;
    }

    // 할 일을 삭제한다 (id값을 이용해서 해당 값만 삭제)
    public boolean deleteTodoList(Long id) {
        int queryResult = 0;
        if(id != null)
            queryResult = todoMapper.deleteTodoList(id);
        return (queryResult == 1) ? true : false;
    }
}
