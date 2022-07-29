package org.sofka.mykrello.model.service;
import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.sofka.mykrello.model.domain.TaskDomain;
import org.sofka.mykrello.model.repository.BoardRepository;
import org.sofka.mykrello.model.repository.ColumnForBoardRepository;
import org.sofka.mykrello.model.repository.TaskRepository;
import org.sofka.mykrello.model.repository.ColumnRepository;
import org.sofka.mykrello.model.service.interfaces.TaskServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService implements TaskServiceInterface {

    Logger log = Logger.getLogger("Logger");

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private LogService logService;

    @Override
    public List<TaskDomain> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public TaskDomain findById(Integer id) {
        Optional<TaskDomain> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    @Override
    public TaskDomain create(TaskDomain task) {
        return taskRepository.save(task);
    }

    @Override
    public TaskDomain update(Integer id, TaskDomain task) {
        Optional<TaskDomain> taskUpdate = taskRepository.findById(id);

        if(taskUpdate.isPresent()){
            var taskSend = taskRepository.save(task);
            return taskSend;
        } else {
            return null;
        }

    }

    @Override
    public TaskDomain delete(Integer id) {

        Optional<TaskDomain> taskDelete = taskRepository.findById(id);

        if (taskDelete.isPresent()) {
            taskRepository.deleteById(id);
        } else {
            log.info("No se encontro a la tarea");
        }

        return taskDelete.orElse(null);

    }
}
