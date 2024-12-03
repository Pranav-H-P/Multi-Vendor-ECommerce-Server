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
    @Query("""
            SELECT new com.panic.sasserver.dto.ProductDTO(p.name, v.name, p.id, p.vendorId, p.price, p.description, p.categoryId)
            FROM Product p JOIN Vendor v ON p.vendorId = v.id WHERE p.id = :id""")
    ProductDTO getDTOFromId(@Param("id") Long id);

    // searches based on category name, product name and vendor name
    @Query("""
            SELECT new com.panic.sasserver.dto.ProductDTO(p.name, v.name, p.id, p.vendorId, p.price, p.description, p.categoryId)
            FROM Product p
            JOIN Vendor v ON p.vendorId = v.id
            JOIN Category c ON p.categoryId = c.id
            WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))
            OR LOWER(v.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))
            OR LOWER(c.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))""")

    List<ProductDTO> getDTOListFromSearchTerm(@Param("searchTerm") String searchTerm);


    // search with vendor filter
    @Query("""
            SELECT new com.panic.sasserver.dto.ProductDTO(p.name, v.name, p.id, p.vendorId, p.price, p.description, p.categoryId)
            FROM Product p
            JOIN Vendor v ON p.vendorId = v.id
            JOIN Category c ON p.categoryId = c.id
            WHERE v.name = :vendorName
            AND ((LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))
            OR LOWER(c.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))))""")
    List<ProductDTO> getDTOListByVendor( @Param("searchTerm") String searchTerm, @Param("vendorName") String vendorName);

    // search with category filter
    @Query("""
            SELECT new com.panic.sasserver.dto.ProductDTO(p.name, v.name, p.id, p.vendorId, p.price, p.description, p.categoryId)
            FROM Product p
            JOIN Vendor v ON p.vendorId = v.id
            JOIN Category c ON p.categoryId = c.id
            WHERE (LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))
            OR LOWER(v.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')))
            AND (
            c.name = :categoryName
            OR c.parentId IN (
                SELECT c2.id
                FROM Category c2
                WHERE c2.parentId = (SELECT c3.id FROM Category c3 WHERE c3.name = :categoryName)
            ))""")
    List<ProductDTO> getDTOListByCategory( @Param("searchTerm") String searchTerm, @Param("categoryTerm") String categoryName);

    //search with category and vendor
    @Query("""
            SELECT new com.panic.sasserver.dto.ProductDTO(p.name, v.name, p.id, p.vendorId, p.price, p.description, p.categoryId)
            FROM Product p
            JOIN Vendor v ON p.vendorId = v.id
            JOIN Category c ON p.categoryId = c.id
            WHERE v.name = :vendorName AND (
                c.name = :categoryName OR
                c.parentId IN (SELECT c2.id FROM Category c2 WHERE c2.parentId = (SELECT c3.id FROM Category c3 WHERE c3.name = :categoryName))
            )
            AND LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))
            """)
    List<ProductDTO> getDTOListByVendorAndCategory( @Param("searchTerm") String searchTerm, @Param("vendorName") String vendorName, @Param("categoryName") String categoryName);
}

