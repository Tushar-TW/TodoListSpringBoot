package com.example.demo.services;

import com.example.demo.entity.todos;

import java.util.List;

public interface Services {
    public List<todos> getTodos();
    public todos addTodos(todos todo);
    public todos updateTodos(todos todo);
    public void deleteTodos(Long parseLong);
}
