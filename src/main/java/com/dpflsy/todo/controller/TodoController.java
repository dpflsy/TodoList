package com.dpflsy.todo.controller;

import com.dpflsy.todo.domain.Todo;
import com.dpflsy.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/todo")
@RestController
public class TodoController {

    private final TodoService todoService;

    @GetMapping()
    public List<Todo> getTodoList() {
        return todoService.getTodoList();
    }

    @GetMapping("/{id}")
    public List<Todo> getOneTodoList(@PathVariable Long id) {
        return todoService.getOneTodoList(id);
    }

    @PostMapping("/insert")
    public String insertTodoList(Todo todo) {
        todoService.insertTodoList(todo);
        System.out.println(String.valueOf(todo));
        return String.valueOf(todo);
    }

    @PatchMapping("/update")
    public String updateTodoList(Todo todo) {
        todoService.updateTodoList(todo);
        return String.valueOf(todo);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTodoList(@PathVariable Long id) {
        todoService.deleteTodoList(id);
        return String.valueOf(id);
    }

}
