package com.panic.sasserver.repository;


import com.panic.sasserver.model.AccessRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessRepository extends JpaRepository<AccessRecord, Long> {
}
