package com.github.todoapi.DTO;

import com.github.todoapi.ENUMS.TASK_PRIORITIES;
import com.github.todoapi.ENUMS.TASK_STATUS;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateTaskDTO {
    private String title;
    private String description;
    private TASK_STATUS status;
    private TASK_PRIORITIES priority;
    private LocalDate dueDate;

    public UpdateTaskDTO(String title, String description, TASK_STATUS status, TASK_PRIORITIES priority, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    public UpdateTaskDTO(){}

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

    public TASK_STATUS getStatus() {
        return status;
    }

    public void setStatus(TASK_STATUS status) {
        this.status = status;
    }

    public TASK_PRIORITIES getPriority() {
        return priority;
    }

    public void setPriority(TASK_PRIORITIES priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
