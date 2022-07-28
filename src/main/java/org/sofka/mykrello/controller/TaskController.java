package org.sofka.mykrello.controller;

import org.sofka.mykrello.model.domain.TaskDomain;
import org.sofka.mykrello.model.service.TaskService;
import org.sofka.mykrello.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class TaskController {

    @Autowired
    private MyResponseUtility response;

    @Autowired
    private TaskService taskService;
    /*
    @GetMapping(path = "/api/v1/task")
    public ResponseEntity<MyResponseUtility> index() {
            response.data = taskService.getAll();
            return new ResponseEntity<>(response, HttpStatus.OK);
    }*/


    /**
     * El metodo getTaskById recibe un id de una tarea y retorna una tarea con ese id.
     * @param taskId id de la tarea que se desea obtener.
     * @return una tarea con ese id.
     */
    @GetMapping(path = "/api/v1/task/{id}")
    public ResponseEntity<MyResponseUtility> getTaskById(@PathVariable(value = "id") Integer taskId) {
        response.data = taskService.findById(taskId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /**
     * El metodo create recibe una tarea y la crea en la base de datos.
     * @param task tarea que se desea crear.
     * @return una tarea creada.
     */
    @PostMapping(path = "/api/v1/task")
    public ResponseEntity<MyResponseUtility> create(@RequestBody TaskDomain task) {
        var newTask = taskService.create(task);
        response.data = taskService.create(task);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }



    @PutMapping(path = "/api/v1/task/{id}")
    public ResponseEntity<MyResponseUtility> put(@PathVariable(value = "id") Integer id,@RequestBody TaskDomain task) {
        response.data = taskService.update(id, task);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @DeleteMapping(path = "/api/v1/task/{id}")
    public ResponseEntity<MyResponseUtility> delete(@PathVariable(value = "id") Integer id) {
        try {
            response.data = "";
            taskService.delete(id);
        }
        catch (Exception e){
            Integer x =0;
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
