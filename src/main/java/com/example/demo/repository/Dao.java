package com.example.demo.repository;

import com.example.demo.entity.todos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Dao extends JpaRepository<todos, Long> {
}
