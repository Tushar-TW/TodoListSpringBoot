package com.example.demo.controller;

import com.example.demo.entity.todos;
import com.example.demo.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controller {

    @Autowired
    private Services services;

    @GetMapping(value = "/todos")
    public List<todos> getTodos() {

            return  this.services.getTodos();

    }

    @PostMapping(value = "/todos")
    public todos addTodos(@RequestBody todos todo) {
        return this.services.addTodos(todo);
    }

    @PutMapping(value = "/todos")
    public todos updateTodos(@RequestBody todos todo) {
        return this.services.updateTodos(todo);
    }

    @DeleteMapping(value = "/todos/{id}")
    public ResponseEntity<HttpStatus> deleteTodos(@PathVariable String id) {
        try {
            this.services.deleteTodos(Long.parseLong(id));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
