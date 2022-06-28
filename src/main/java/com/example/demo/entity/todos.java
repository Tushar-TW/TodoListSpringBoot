package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class todos {

    @Id
    private Long id;
    private String task;
    private String category;
    private String priority;
    private String stage;

    public todos(Long id, String task, String category, String priority, String stage) {
        this.id = id;
        this.task = task;
        this.category = category;
        this.priority = priority;
        this.stage = stage;
    }

    public todos() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    @Override
    public String toString() {
        return "todos{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", category='" + category + '\'' +
                ", priority='" + priority + '\'' +
                ", stage='" + stage + '\'' +
                '}';
    }
}
