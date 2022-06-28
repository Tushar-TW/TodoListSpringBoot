package com.example.demo.services;

import com.example.demo.entity.todos;
import com.example.demo.repository.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesImpl implements Services {

    @Autowired
    private Dao dao;

    public ServicesImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public List<todos> getTodos() {
        return dao.findAll();
    }

    @Override
    public todos addTodos(todos todo) {
        dao.save(todo);
        return todo;
    }

    @Override
    public todos updateTodos(todos todo) {
        dao.save(todo);
        return todo;
    }

    @Override
    public void deleteTodos(Long parseLong) {
     todos entity = dao.getReferenceById(parseLong);
     dao.delete(entity);
    }

}
