package com.example.rideservicebackend.controller;

import com.example.rideservicebackend.request.TaskCreateRequest;
import com.example.rideservicebackend.request.TaskUpdateRequest;
import com.example.rideservicebackend.response.TaskResponse;
import com.example.rideservicebackend.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/create")
    public TaskResponse create(@RequestBody TaskCreateRequest request) {
        return taskService.create(request);
    }

    @GetMapping("/{id}")
    public TaskResponse getById(@PathVariable Long id) {
        return taskService.getById(id);
    }

    @GetMapping
    public List<TaskResponse> getAll() {
        return taskService.getAll();
    }

    @PutMapping("/{id}")
    public TaskResponse update(@PathVariable Long id,
                               @RequestBody TaskUpdateRequest request) {
        return taskService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
