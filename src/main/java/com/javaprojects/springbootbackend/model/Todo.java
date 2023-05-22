package com.javaprojects.springbootbackend.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "todos")
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 4, max = 25, message = "size of task should be between {min} and {max} characters")
    @NotNull (message = "task cannot be null")
    @NotBlank (message = "task cannot be white space")
    @Column(name = "task")
    private String task;
    @Column(name = "completed")
    private boolean completed;


}
