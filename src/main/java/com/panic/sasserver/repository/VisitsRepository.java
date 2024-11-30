package com.panic.sasserver.repository;

import com.panic.sasserver.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitsRepository extends JpaRepository<Visit, Long> {
}
