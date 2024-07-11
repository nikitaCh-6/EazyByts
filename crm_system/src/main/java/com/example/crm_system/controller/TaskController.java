package com.example.crm_system.controller;

import com.example.crm_system.model.Tasks;
import com.example.crm_system.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String getAllTasks(Model model) {
        List<Tasks> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "task-list"; // Return view name
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute Tasks task) {
        taskService.saveTask(task);
        return "redirect:/tasks/"; // Redirect to task list
    }

    @PostMapping("/edit")
    public String editTask(@ModelAttribute Tasks task) {
        taskService.saveTask(task);
        return "redirect:/tasks/"; // Redirect to task list
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks/"; // Redirect to task list
    }
}


