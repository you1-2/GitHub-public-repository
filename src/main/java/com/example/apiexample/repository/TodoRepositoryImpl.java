package com.example.apiexample.repository;

import com.example.apiexample.Todo;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class TodoRepositoryImpl implements TodoRepository {
    private final Map<Long, Todo> data = new HashMap<>();
    private Long idCounter = 1L;

    public Todo save(Todo todo) {
        todo.setId(idCounter++);
        data.put(todo.getId(), todo);
        return todo;
    }

    public List<Todo> findAll() {
        return new ArrayList<>(data.values());
    }

    public Optional<Todo> findById(Long id) {
        return Optional.ofNullable(data.get(id));
    }

}
