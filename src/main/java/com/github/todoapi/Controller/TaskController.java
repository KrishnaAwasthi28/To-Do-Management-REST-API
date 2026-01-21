package com.github.todoapi.Controller;


import com.github.todoapi.DTO.TaskReqDTO;
import com.github.todoapi.DTO.TaskResDTO;
import com.github.todoapi.DTO.TaskResponse;
import com.github.todoapi.DTO.UpdateTaskDTO;
import com.github.todoapi.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/tasks")
    public ResponseEntity<TaskResDTO> addTask(@RequestBody TaskReqDTO taskReqDTO){
        return ResponseEntity.ok(taskService.addTask(taskReqDTO));
    }
    @GetMapping("/tasks")
    public ResponseEntity<List<TaskResponse>> getAllTasks(){
        return ResponseEntity.ok(taskService.getAllTasks());
    }
    @PutMapping("/tasks/{taskId}")
    public ResponseEntity<TaskResponse> updateTask(@PathVariable Long taskId, @RequestBody UpdateTaskDTO updateTaskDTO){
        return ResponseEntity.ok(taskService.updateTask(taskId,updateTaskDTO));
    }
    @DeleteMapping("/tasks/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long task_Id){
        taskService.deleteTask(task_Id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/tasks/{taskId}/complete")
    public ResponseEntity<TaskResponse> markTaskAsCompleted(@PathVariable Long taskId) {
        TaskResponse response = taskService.markTaskAsCompleted(taskId);
        return ResponseEntity.ok(response);
    }
}
