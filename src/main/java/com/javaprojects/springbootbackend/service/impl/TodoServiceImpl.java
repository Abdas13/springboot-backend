package com.javaprojects.springbootbackend.service.impl;

import com.javaprojects.springbootbackend.exception.ResourceNotFoundException;
import com.javaprojects.springbootbackend.model.Todo;
import com.javaprojects.springbootbackend.model.dto.TodoRequest;
import com.javaprojects.springbootbackend.repository.TodoRepository;
import com.javaprojects.springbootbackend.service.TodoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo saveTask(Todo todo) {
        return todoRepository.save(todo);
    }
    @Override
    public List<Todo> getAllTasks() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTaskById(Long id) {


        Todo todo=todoRepository.findById(id).orElseThrow(() ->
               new ResourceNotFoundException("Todo","Id",id));
        return todo;
    }

    @Override
    public void updateTaskById(TodoRequest todoRequest, Long id) {
        Todo existingTodo=todoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Todo", "Id", id));

        existingTodo.setTask(todoRequest.getAddTask());
        existingTodo.setCompleted(todoRequest.isCompleted());

        todoRepository.save(existingTodo);

    }



    @Override
    public void deleteTaskById(Long id) {

        todoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Todo","Id", id));

        todoRepository.deleteById(id);

    }


}
