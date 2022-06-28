package com.example.demo.services;

import com.example.demo.entity.todos;
import com.example.demo.repository.Dao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class servicesTest {

    @Mock
    private Dao dao;

    private ServicesImpl service;

    @BeforeEach
    void setUp() {
        this.service = new ServicesImpl(this.dao);
    }

    @Test
    void shouldReturnEqualWhenGetTodosMethodIsVerifiedAgainstFindAllMethodOfDaoLayer() {
        service.getTodos();
        verify(dao).findAll();
    }

    @Test
    void shouldReturnEqualWhenAddTodosMethodIsVerifiedAgainstSaveMethodOfDaoLayer() {
        todos todo = new todos(14L, "chatting", "time pass", "low", "not done");
        service.addTodos(todo);
        verify(dao).save(todo);
    }

    @Test
    void shouldReturnEqualWhenUpdateTodosMethodIsVerifiedAgainstSaveMethodOfDaoLayer() {
        todos todo = new todos(10L, "writing", "time pass", "low", "done");
        service.updateTodos(todo);
        verify(dao).save(todo);
    }

}
