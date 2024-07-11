package com.example.crm_system.service;

import com.example.crm_system.model.Tasks;
import com.example.crm_system.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Tasks> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Tasks> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Tasks saveTask(Tasks task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}

