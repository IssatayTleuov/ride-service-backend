package com.example.rideservicebackend.service;

import com.example.rideservicebackend.entity.Task;
import com.example.rideservicebackend.exception.NotFoundException;
import com.example.rideservicebackend.repository.TaskRepository;
import com.example.rideservicebackend.request.TaskCreateRequest;
import com.example.rideservicebackend.request.TaskUpdateRequest;
import com.example.rideservicebackend.response.TaskResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskResponse create(TaskCreateRequest request) {
        Task task = new Task();
        task.setTitle(request.title());
        task = taskRepository.save(task);
        return new TaskResponse(task.getId(), task.getTitle(), task.isCompleted());
    }

    public TaskResponse getById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new NotFoundException("Task not found");
        }
        Task task = optionalTask.get();
        return new TaskResponse(task.getId(), task.getTitle(), task.isCompleted());
    }

    public List<TaskResponse> getAll() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(task -> new TaskResponse(task.getId(), task.getTitle(), task.isCompleted()))
                .toList();
    }

    public TaskResponse update(Long id, TaskUpdateRequest request) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new NotFoundException("Task not found");
        }
        Task task = optionalTask.get();
        task.setTitle(request.title());
        task.setCompleted(request.completed());
        task = taskRepository.save(task);
        return new TaskResponse(task.getId(), task.getTitle(), task.isCompleted());
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
