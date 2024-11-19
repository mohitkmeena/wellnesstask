package com.mohit.wellnesstask.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit.wellnesstask.model.Task;
import com.mohit.wellnesstask.repository.TaskRepository;

@Service
public class TaskService {
    /*
     * it is the service layer where we will do all the processing
     */
    @Autowired
    private TaskRepository taskRepository;
    // get all tasks
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }


    // get task by id
    public Task getTask(int id) {
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent()){
            return task.get();
        }else{
            throw new RuntimeException("Task not found");
        }
    }


    //update task status to completed
    public Task updateTask(int id) {
     Optional<Task> taskget =    taskRepository.findById(id);
     if(taskget.isPresent()){
       Task task= taskget.get();
        
        task.setStatus(Task.Status.completed);
        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task);
     }else{
        throw new RuntimeException("Task not found");
     }
       
    }


    
    // delete task
    public void deleteTask(int id) {
        Optional<Task> exitingtask = taskRepository.findById(id);
        if(!exitingtask.isPresent()){
            throw new RuntimeException("Task not found");
        }
        taskRepository.deleteById(id);
    }

    //add task post the task
    public Task addTask(Task task) {
        Optional<Task> exitingtask = taskRepository.findById(task.getId());
        if(exitingtask.isPresent()){
            throw new RuntimeException("Task already exists");
        }
        task.setStatus(Task.Status.pending);
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }


    /* 
    update task by matching the given and already existing details 
       if one details missing in the updated task then use the existing value

    */
    public Task updateTask(int id, Task updatedTask) {
        Optional<Task> existingTaskOptional = taskRepository.findById(id);
        
        if (existingTaskOptional.isPresent()) {
            Task existingTask = existingTaskOptional.get();
            
            
            existingTask.setTitle(updatedTask.getTitle() != null ? updatedTask.getTitle() : existingTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription() != null ? updatedTask.getDescription() : existingTask.getDescription());
            existingTask.setDueDate(updatedTask.getDueDate() != null ? updatedTask.getDueDate() : existingTask.getDueDate());
            existingTask.setStatus(updatedTask.getStatus() != null ? updatedTask.getStatus() : existingTask.getStatus());
            existingTask.setUpdatedAt(LocalDateTime.now());
            if (existingTask.getCreatedAt() == null) {
                existingTask.setCreatedAt(LocalDateTime.now());
            }
            
            return taskRepository.save(existingTask);
        } else {
            throw new RuntimeException("Task not found with id: " + updatedTask.getId());
        }
    }
    
}
