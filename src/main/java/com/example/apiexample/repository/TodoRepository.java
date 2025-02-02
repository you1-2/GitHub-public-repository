package com.example.apiexample.repository;

import com.example.apiexample.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    public Todo save(Todo todo);

    public List<Todo> findAll();

    public Optional<Todo> findById(Long id);
}
