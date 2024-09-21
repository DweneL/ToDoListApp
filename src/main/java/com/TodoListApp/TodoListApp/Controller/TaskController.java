package com.TodoListApp.TodoListApp.Controller;


import com.TodoListApp.TodoListApp.Model.Task;
import com.TodoListApp.TodoListApp.Repository.TaskRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

private final TaskRepository taskRepository;


    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @GetMapping("api/hello")
    public String sayHello() {
        return "Hello World";
    }



    @GetMapping("api/tasks")
    public List<Task> getAllTasks(){
        System.out.println("Hello World");
        return this.taskRepository.findAll();
    }

    @GetMapping("api/task")
    public Task createTask(@RequestBody Task tasks){
        System.out.println("Hello Worlld");
        return this.taskRepository.save(tasks);
    }


    @GetMapping("api/tasks/{id}")
    public Task getTaskById(@PathVariable Long id){
        return this.taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found with id " + id));

    }






}
