package org.sofka.mykrello.controller;


import org.sofka.mykrello.model.domain.TaskDomain;
import org.sofka.mykrello.model.service.TaskService;
import org.sofka.mykrello.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")
@RestController
public class TaskController {

    @Autowired
    private MyResponseUtility response;
    @Autowired
    private TaskService taskService;

    @GetMapping(path = "/api/v1/task")
    public ResponseEntity<MyResponseUtility> get(){
        response.data = taskService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/api/v1/task/{id}")
    public ResponseEntity<MyResponseUtility> getById(@PathVariable("id") Integer id){
        response.data = taskService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/api/v1/task")
    public ResponseEntity<MyResponseUtility> post(@RequestBody TaskDomain task){
        response.data = taskService.create(task);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(path = "/api/v1/task/{id}")
    public ResponseEntity<MyResponseUtility> put(@PathVariable("id") Integer id, @RequestBody TaskDomain task){
        response.data = taskService.update(id,task);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/api/v1/task/{id}")
    public ResponseEntity<MyResponseUtility> delete(@PathVariable("id") Integer id){
        response.data =  taskService.findById(id);
        taskService.delete(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
