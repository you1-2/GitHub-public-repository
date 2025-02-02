package com.example.apiexample.controller;// Controller
import com.example.apiexample.Todo;
import com.example.apiexample.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/todo")
public class TodoController {


    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // TODO 항목 작성 및 등록
    @PostMapping("/add")
    public ResponseEntity<Map<String, String>> createTodo(@RequestBody Todo todo) {
        todoService.createTodo(todo);
        Map<String, String> response = new HashMap<>();
        response.put("message", "ok");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // TODO 항목(제목) 리스트 불러오기
    @GetMapping
    public ResponseEntity<Map<String, List<String>>> getTodoTitles() {
        List<String> titles = new ArrayList<>();
        for (Todo todo : todoService.getTodoTitles()) {
            titles.add(todo.getTitle());
        }
        Map<String, List<String>> response = new HashMap<>();
        response.put("data", titles);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // TODO 항목 제목 및 상세 내용 조회
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getTodoDetails(@PathVariable Long id) {
        Optional<Todo> todo = todoService.getTodoDetails(id);
        if (todo.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("data", todo.get());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

