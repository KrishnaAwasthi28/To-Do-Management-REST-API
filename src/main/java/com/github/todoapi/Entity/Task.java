package com.github.todoapi.Entity;

import com.github.todoapi.ENUMS.TASK_PRIORITIES;
import com.github.todoapi.ENUMS.TASK_STATUS;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;

    @Column(nullable = false)
    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TASK_PRIORITIES taskPriorities;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TASK_STATUS taskStatus;

    private LocalDate dueDate;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (taskPriorities == null) {
            taskPriorities = TASK_PRIORITIES.MEDIUM;
        }

        if (taskStatus == null) {
            taskStatus = TASK_STATUS.PENDING;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Task(Long taskId, String title, String description, TASK_PRIORITIES taskPriorities, TASK_STATUS taskStatus, LocalDate dueDate, LocalDateTime createdAt, LocalDateTime updatedAt, User user) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.taskPriorities = taskPriorities;
        this.taskStatus = taskStatus;
        this.dueDate = dueDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
    }

    public Task(){}

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TASK_PRIORITIES getTaskPriorities() {
        return taskPriorities;
    }

    public void setTaskPriorities(TASK_PRIORITIES taskPriorities) {
        this.taskPriorities = taskPriorities;
    }

    public TASK_STATUS getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TASK_STATUS taskStatus) {
        this.taskStatus = taskStatus;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
