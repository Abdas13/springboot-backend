package com.javaprojects.springbootbackend.service;

import com.javaprojects.springbootbackend.model.Todo;
import com.javaprojects.springbootbackend.model.dto.TodoRequest;

import java.util.List;

public interface TodoService {

    Todo saveTask(Todo todo);

    List<Todo> getAllTasks();

    Todo getTaskById(Long id);

    void updateTaskById(TodoRequest todoRequest, Long id);

    void deleteTaskById(Long id);
}
