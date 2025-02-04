package com.taskmsys.task_management.controller;

import com.taskmsys.task_management.dto.TaskDTO;
import com.taskmsys.task_management.entity.taskEntity;
import com.taskmsys.task_management.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tms-tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<taskEntity> getAllTasks(TaskDTO taskDTO){
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public taskEntity getTaskById(@PathVariable long id){
        return taskService.getTaskById(id);
    }

    @PostMapping("/createTask")
    public taskEntity createTask(@RequestBody TaskDTO taskDTO){
        return  taskService.createTask(taskDTO);
    }

    @PutMapping("/{id}")
    public taskEntity updateTask(@PathVariable long id, @RequestBody TaskDTO taskDTO){
        return taskService.updateTask(id, taskDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id){
        taskService.deleteTask(id);
    }
}
