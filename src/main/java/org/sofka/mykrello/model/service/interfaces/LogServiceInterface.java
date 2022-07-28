package org.sofka.mykrello.model.service.interfaces;

import java.util.List;

import org.sofka.mykrello.model.domain.LogDomain;
import org.springframework.transaction.annotation.Transactional;

public interface LogServiceInterface {

		public List<LogDomain> getAll();

    public List<LogDomain> findById(Integer id);

    public LogDomain create(LogDomain log);

		@Transactional(readOnly = false)
		void deleteAllByTaskId(Integer id);

		void delete(Integer id);
}
