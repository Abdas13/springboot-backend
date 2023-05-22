package com.javaprojects.springbootbackend.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TodoRequest {

    private Long id;

    @Size(min = 4, max = 25, message = "size of task should be between {min} and {max} characters")
    @NotNull(message = "task cannot be null")
    @NotBlank(message = "task cannot be white space")
    @Column(name = "task")
    private String addTask;

    private boolean isCompleted;

}
