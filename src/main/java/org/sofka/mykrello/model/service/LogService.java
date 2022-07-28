package org.sofka.mykrello.model.service;

import java.util.List;

import org.sofka.mykrello.model.domain.LogDomain;
import org.sofka.mykrello.model.repository.LogRepository;
import org.sofka.mykrello.model.service.interfaces.LogServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogService implements LogServiceInterface {

    @Autowired
    LogRepository logRepository;

    @Override
    public List<LogDomain> getAll() {
        return null;
    }

    @Override
    public List<LogDomain> findById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public LogDomain create(LogDomain log) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteAllByTaskId(Integer id) {
        logRepository.deleteByTask(id);
    }

    @Override
    public void delete(Integer id) {
    }

    @Transactional(readOnly = true) // El Transactional lo utilizo para que no se pueda hacer una consulta sin haber iniciado una transaccion
    public List<LogDomain> findAll() {
        List<LogDomain> LogAll = logRepository.findAll();
        return LogAll;
    }
}
