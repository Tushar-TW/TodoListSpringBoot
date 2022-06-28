package com.example.demo.controller;

import com.example.demo.entity.todos;
import com.example.demo.repository.Dao;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class controllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private Dao dao;

    @Test
    void shouldReturnTodosListOnGivingTodosGetTodosEndpoint() {
        String baseUrl = "http://localhost:" + port + "/todos";
        ResponseEntity<todos[]> response = restTemplate.getForEntity(baseUrl, todos[].class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void shouldReturnAddedTodoGivenPostTodosEndpoint() {
        String baseUrl = "http://localhost:" + port + "/todos";
        todos todo = new todos(11L, "swimming", "health", "low", "done");
        ResponseEntity<todos> response = restTemplate.postForEntity(baseUrl, todo, todos.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void shouldReturnUpdatedTodoGivenPutTodosEndpoint() {
        String baseUrl = "http://localhost:" + port + "/todos";
        HttpEntity<todos> request = new HttpEntity<>(new todos(12L, "joking", "health", "low", "not done"));
        ResponseEntity<todos> response = restTemplate.exchange(baseUrl, HttpMethod.PUT, request, todos.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

    }

    @Test
    void  shouldReturnStatusOkGivenDeleteTodosEndPoint() {
        String baseUrl = "http://localhost:" + port + "/todos";
        int recordCount = dao.findAll().size();
        //assertEquals(11, recordCount);
        restTemplate.delete(baseUrl + "/{id}", 5);
        assertEquals(recordCount-1, dao.findAll().size());
    }
}
