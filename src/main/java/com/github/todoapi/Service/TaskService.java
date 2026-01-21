package com.github.todoapi.Service;

import com.github.todoapi.DTO.TaskReqDTO;
import com.github.todoapi.DTO.TaskResDTO;
import com.github.todoapi.DTO.TaskResponse;
import com.github.todoapi.DTO.UpdateTaskDTO;
import com.github.todoapi.ENUMS.TASK_STATUS;
import com.github.todoapi.Entity.Task;
import com.github.todoapi.Entity.User;
import com.github.todoapi.Repository.TaskRepository;
import com.github.todoapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public TaskResDTO addTask(TaskReqDTO taskReqDTO) {
        String email = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByEmail(email);
        if(user==null) throw new RuntimeException("User not found");
        Task task=new Task();
        task.setTitle(taskReqDTO.getTitle());
        task.setDescription(taskReqDTO.getDescription());
        task.setTaskPriorities(taskReqDTO.getPriority());
        task.setUser(user);
        Task taskRes=taskRepository.save(task);
        return new TaskResDTO(taskRes.getTaskId(),taskRes.getTitle(),taskRes.getTaskStatus());
    }

    public List<TaskResponse> getAllTasks() {

        String email = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByEmail(email);
        if(user==null) throw new RuntimeException("User not found");

        List<Task> tasks = taskRepository.findByUser(user);

        return tasks.stream()
                .map(task -> new TaskResponse(
                        task.getTaskId(),
                        task.getTitle(),
                        task.getDescription(),
                        task.getTaskStatus().name(),
                        task.getTaskPriorities().name(),
                        task.getDueDate()
                ))
                .collect(Collectors.toList());
    }

    public TaskResponse updateTask(Long taskId, UpdateTaskDTO request) {

        String email = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByEmail(email);
        if(user==null) throw new RuntimeException("User not found");

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if (!task.getUser().getUser_id().equals(user.getUser_id())) {
            throw new RuntimeException("You are not allowed to update this task");
        }

        if (request.getTitle() != null) task.setTitle(request.getTitle());
        if (request.getDescription() != null) task.setDescription(request.getDescription());
        if (request.getStatus() != null) task.setTaskStatus(request.getStatus());
        if (request.getPriority() != null) task.setTaskPriorities(request.getPriority());
        if (request.getDueDate() != null) task.setDueDate(request.getDueDate());

        Task updatedTask = taskRepository.save(task);

        return new TaskResponse(
                updatedTask.getTaskId(),
                updatedTask.getTitle(),
                updatedTask.getDescription(),
                updatedTask.getTaskStatus().name(),
                updatedTask.getTaskPriorities().name(),
                updatedTask.getDueDate()
        );
    }

    public void deleteTask(Long taskId) {

        String email = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByEmail(email);
        if(user==null) throw new RuntimeException("User not found");

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if (!task.getUser().getUser_id().equals(user.getUser_id())) {
            throw new RuntimeException("You are not allowed to delete this task");
        }

        taskRepository.delete(task);
    }

    public TaskResponse markTaskAsCompleted(Long taskId) {

        String email = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByEmail(email);
        if(user==null) throw new RuntimeException("User not found");

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if (!task.getUser().getUser_id().equals(user.getUser_id())) {
            throw new RuntimeException("You are not allowed to modify this task");
        }

        task.setTaskStatus(TASK_STATUS.COMPLETED);
        Task updatedTask = taskRepository.save(task);

        return new TaskResponse(
                updatedTask.getTaskId(),
                updatedTask.getTitle(),
                updatedTask.getDescription(),
                updatedTask.getTaskStatus().name(),
                updatedTask.getTaskPriorities().name(),
                updatedTask.getDueDate()
        );
    }
}
