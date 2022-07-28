package org.sofka.mykrello.model.service;

import java.util.List;
import java.util.Optional;

import org.sofka.mykrello.model.domain.LogDomain;
import org.sofka.mykrello.model.domain.TaskDomain;
import org.sofka.mykrello.model.repository.ColumnForBoardRepository;
import org.sofka.mykrello.model.repository.ColumnRepository;
import org.sofka.mykrello.model.repository.TaskRepository;
import org.sofka.mykrello.model.service.interfaces.TaskServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TaskService implements TaskServiceInterface {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ColumnRepository columnRepository;

    @Autowired
    private LogService logService;

    @Override
    public List<TaskDomain> findAllTasksById(Integer idBoard) {
        return null;
    }


    @Override
    @Transactional(readOnly = true)
    public List<TaskDomain> getAll() {
        return taskRepository.findAll();
    }


    public TaskDomain findById(Integer id) {
        Optional<TaskDomain> tarea = taskRepository.findById(id);
        return tarea.isPresent() ? tarea.get() : null;
    }


    @Override
    @Transactional(readOnly = false)
    public TaskDomain create(TaskDomain task) {
        var newTask = taskRepository.save(task); // Guarda la tarea en la base de datos
        var column = columnRepository.findById(task.getColumn()).orElse(null);// TODO: verificar si esto es correcto
        var log = new LogDomain(newTask.getId(), column, column);// Crea un log con la tarea y la columna actual
        logService.create(log); // Guarda el log en la base de datos
        return newTask; // Retorna la tarea creada
    }


    @Override
    public TaskDomain update(Integer id, TaskDomain task) {
        task.setId(id); // Setea el id de la tarea a actualizar
        return  taskRepository.save(task); // Guarda la tarea en la base de datos
        //task.setId(id);
        //var a = taskRepository.save(task);
        //return a;
    }


    @Override
    public TaskDomain delete(Integer id) {
        var opcionalTasks = taskRepository.findById(id); // Busca la tarea a eliminar en la base de datos pod idBoard
        if (opcionalTasks.isPresent()) { // Si la tarea existe
            var task = opcionalTasks.get(); // Guarda la tarea en una variable
            var columnsTask = task.getColumn(); // Guarda la columna en una variable
        } else {
            return null; // Si la tarea no existe retorna null
        }
        return null;
    }
}

