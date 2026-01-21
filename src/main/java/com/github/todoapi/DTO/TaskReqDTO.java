package com.github.todoapi.DTO;

import com.github.todoapi.ENUMS.TASK_PRIORITIES;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskReqDTO {

    @NotBlank(message = "Title cannot be blank")
    private String title;

    private String description;

    @NotBlank(message = "You must define Task Priority")
    private TASK_PRIORITIES priority;

    @NotBlank(message = "Task must have due date")
    private LocalDate dueDate;

    public TaskReqDTO(String title, String description, TASK_PRIORITIES priority, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
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
