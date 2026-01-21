package com.github.todoapi.DTO;

import com.github.todoapi.ENUMS.TASK_STATUS;
import lombok.Data;

@Data
public class TaskResDTO {

    private Long id;

    private String title;

    private TASK_STATUS status;

    public TaskResDTO(Long id, String title, TASK_STATUS status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }
    public TaskResDTO(){}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TASK_STATUS getStatus() {
        return status;
    }

    public void setStatus(TASK_STATUS status) {
        this.status = status;
    }
}
