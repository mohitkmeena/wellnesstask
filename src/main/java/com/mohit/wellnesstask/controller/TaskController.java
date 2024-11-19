package com.mohit.wellnesstask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.wellnesstask.model.Task;
import com.mohit.wellnesstask.service.TaskService;




@RestController


public class TaskController {


    /*
     * it is a controller layer to manage all the user requests and mappings
     * 
     */
    @Autowired
    private TaskService taskService;
    
   // to get all task in json format
    @GetMapping(path="/tasks",produces={"application/json"})
    @ResponseBody
    public List<Task> getAllTasks() {
        return taskService.getTasks();
    }
    // to get  task of given id in json format
    @GetMapping(path="tasks/{id}",produces={"application/json"})
    
    public Task getTask(@PathVariable("id") int id) {
        return taskService.getTask(id);
    }
    // to post/ add new task
    @PostMapping("/tasks")
    public Task postTask(@RequestBody Task task) {
       return taskService.addTask(task);
         
    }
    //update task of the given id
    @PutMapping("tasks/{id}")
    public Task updateTask(@PathVariable("id") int id,@RequestBody Task task) {
        return taskService.updateTask(id,task);
    }
    // delete task of the given id
    @DeleteMapping("tasks/{id}")
    public void deleteTask(@PathVariable("id") int id) {
        taskService.deleteTask(id);
    }
   
    //update task status to completed
    @PatchMapping("tasks/{id}")
    public Task completedTask(@PathVariable("id") int id) {
        return taskService.updateTask(id);
    }    
}
