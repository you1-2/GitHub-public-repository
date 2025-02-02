package com.example.apiexample.service;

import com.example.apiexample.Todo;
import com.example.apiexample.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void createTodo(Todo todo) {
        todoRepository.save(todo);
    }

    public List<Todo> getTodoTitles() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoDetails(Long id) {
        return todoRepository.findById(id);
    }
}
