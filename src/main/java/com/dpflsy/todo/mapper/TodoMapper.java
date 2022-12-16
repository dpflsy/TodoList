package com.dpflsy.todo.mapper;

import com.dpflsy.todo.domain.Todo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// dao : 쿼리를 호출하는 객체

@Mapper
public interface TodoMapper {
    public List<Todo> getTodoList();
    public List<Todo> getOneTodoList(Long id);
    public int insertTodoList(Todo params);
    public int updateTodoList(Todo params);
    public int deleteTodoList(Long id);
}
