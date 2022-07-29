package org.sofka.mykrello.model.service.interfaces;

import java.util.List;

import org.sofka.mykrello.model.domain.TaskDomain;

public interface TaskServiceInterface {

    public List<TaskDomain> findAll();

    public TaskDomain findById(Integer id);

    public TaskDomain create(TaskDomain task);

    public TaskDomain update(Integer id, TaskDomain task);

    public TaskDomain delete(Integer id);
}
