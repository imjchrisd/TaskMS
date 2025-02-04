package com.taskmsys.task_management.service;

import com.taskmsys.task_management.dto.TaskDTO;
import com.taskmsys.task_management.entity.taskEntity;
import com.taskmsys.task_management.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public taskEntity createTask(TaskDTO taskDTO){
        taskEntity newTask = new taskEntity();
        newTask.setTitle(taskDTO.getTitle());
        newTask.setDescription(taskDTO.getDescription());
        newTask.setStatus(taskDTO.getStatus());
        newTask.setCreatedAt(taskDTO.getCreatedAt());
        newTask.setUpdatedAt(taskDTO.getUpdatedAt());
        newTask.setDueDate(taskDTO.getDueDate());

        return taskRepository.save(newTask);
    }

    public List<taskEntity> getAllTasks(){
        return taskRepository.findAll();
    }

    public taskEntity getTaskById(long id){
        Optional<taskEntity> task = taskRepository.findById(id);
        return task.orElseThrow(() -> new RuntimeException("Task not Found!"));
    }

    public taskEntity updateTask(long id, TaskDTO taskDTO){
        taskEntity existingTask = getTaskById(id);
        existingTask.setTitle(taskDTO.getTitle());
        existingTask.setDescription(taskDTO.getDescription());
        existingTask.setStatus(taskDTO.getStatus());
        existingTask.setCreatedAt(taskDTO.getCreatedAt());
        existingTask.setUpdatedAt(taskDTO.getUpdatedAt());
        existingTask.setDueDate(taskDTO.getDueDate());

        return taskRepository.save(existingTask);
    }

    public void deleteTask(long id){
        taskRepository.deleteById(id);
    }
}
