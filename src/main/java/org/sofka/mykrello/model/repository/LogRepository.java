package org.sofka.mykrello.model.repository;

import org.sofka.mykrello.model.domain.LogDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface LogRepository extends JpaRepository<LogDomain, Integer>{
	@Modifying
	void deleteByTask(Integer id);
	List<LogDomain> findLogDomainByTaskId(Integer id);

}
