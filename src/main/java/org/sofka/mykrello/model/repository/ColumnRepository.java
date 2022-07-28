package org.sofka.mykrello.model.repository;

import org.sofka.mykrello.model.domain.ColumnDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColumnRepository extends JpaRepository<ColumnDomain, Integer> {

}
