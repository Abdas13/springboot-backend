package com.javaprojects.springbootbackend.controller;

import com.javaprojects.springbootbackend.model.Todo;
import com.javaprojects.springbootbackend.model.dto.TodoRequest;
import com.javaprojects.springbootbackend.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/todos")
public class TodoListController {

    private TodoService todoService;

    public TodoListController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/")
    public ResponseEntity<Map<String,String>> saveTodo(@Valid @RequestBody Todo todo){

        todoService.saveTask(todo);
        Map<String, String> map = new HashMap<>();

        map.put("message","todo is updated successfully");
        map.put("status","true");
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public List<Todo> todoList(){
       return todoService.getAllTasks();
    }

    @GetMapping("/{id}")  // localhost:8080/todos/1
    public ResponseEntity<Todo> getTodoById(@PathVariable("id")  Long id){
        return new ResponseEntity<Todo>(todoService.getTaskById(id),HttpStatus.OK);
    }
    @PutMapping("/{id}")  // localhost:8080/todos/1
    public ResponseEntity<Map<String,String>> updateTaskById(@Valid @PathVariable("id") Long id, @RequestBody TodoRequest todoRequest){
       todoService.updateTaskById(todoRequest,id);
        Map<String, String> map = new HashMap<>();

        map.put("message","todo is updated successfully");
        map.put("status","true");

        return new ResponseEntity<>(map,HttpStatus.OK);
    }



}
