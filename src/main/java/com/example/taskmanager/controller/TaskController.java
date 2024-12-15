package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public ResponseEntity<String> addTask(@RequestBody Task task) {
        taskService.addTask(task);
        return ResponseEntity.ok("Task added successfully!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id) {
        boolean removed = taskService.deleteTask(id);
        if (removed) {
            return ResponseEntity.ok("Task deleted successfully!");
        } else {
            return ResponseEntity.status(404).body("Task not found!");
        }
    }
}
