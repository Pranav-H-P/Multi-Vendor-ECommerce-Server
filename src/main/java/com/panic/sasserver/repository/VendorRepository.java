package com.panic.sasserver.repository;

import com.panic.sasserver.model.Vendor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {


    @Query("""
            SELECT v FROM Vendor v WHERE v.approvalStatus = com.panic.sasserver.enums.VendorStatus.PENDING
            """)
    List<Vendor> getPendingVendors();
}
