package com.panic.sasserver.repository;

import com.panic.sasserver.dto.ProductDTO;
import com.panic.sasserver.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // joins Product table and vendor table
    @Query("SELECT new com.panic.sasserver.dto.ProductDTO(p.name, v.name, p.id, p.vendorId, p.price, p.description) " +
            "FROM Product p JOIN Vendor v ON p.vendorId = v.id WHERE p.id = :id")
    ProductDTO getDTOFromId(@Param("id") Long id);
}
