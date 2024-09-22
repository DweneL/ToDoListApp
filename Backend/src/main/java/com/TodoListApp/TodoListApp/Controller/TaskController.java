package com.TodoListApp.TodoListApp.Controller;


import com.TodoListApp.TodoListApp.Model.Task;
import com.TodoListApp.TodoListApp.Repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@RequestMapping("/api/tasks")
//@CrossOrigin(origins = "http://localhost:63342")
@RestController
public class TaskController {

private final TaskRepository taskRepository;


    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


//    @GetMapping("api/hello")
//    public String sayHello() {
//        return "Hello World";
//    }



    @GetMapping("api/tasks")
    public List<Task> getAllTasks(){
        return this.taskRepository.findAll();
    }

    @PostMapping("api/tasks")
    public Task createTask(@RequestBody Task tasks){
        return this.taskRepository.save(tasks);
    }


    @GetMapping("api/tasks/{id}")
    public Task getTaskById(@PathVariable Long id){
        return this.taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found with id " + id));

    }


    @DeleteMapping("api/tasks/{id}")
    public void  deleteTasks(@PathVariable Long id){
         this.taskRepository.deleteById(id);
    }


    @PutMapping("api/tasks/{id}")
    public void markAsComplete (@RequestBody Task tasks, @PathVariable Long id){
            Task task = this.taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found with id" + id));

            task.setCompleted(tasks.isCompleted());

            //this is saving and updating my task
            this.taskRepository.save(task);
    }

//
//    @PutMapping("todolist/tasks/{id}")
//    public void updateTask(@RequestBody Task task, @PathVariable Long id){
//        Task tasks = this.taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found by Id" + id));
//    }



}
