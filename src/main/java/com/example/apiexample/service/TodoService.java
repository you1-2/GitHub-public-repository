package com.example.apiexample.service;

import com.example.apiexample.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    void createTodo(Todo todo);

    List<Todo> getTodoTitles();

    Optional<Todo> getTodoDetails(Long id);
}
