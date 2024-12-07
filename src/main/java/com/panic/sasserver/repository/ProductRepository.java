package com.panic.sasserver.repository;

import com.panic.sasserver.dto.ProductDTO;
import com.panic.sasserver.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // joins Product table and vendor table
    @Query("""
            SELECT new com.panic.sasserver.dto.ProductDTO(p.name, v.name, p.id, p.vendorId, p.price, p.description, p.categoryId,
            COALESCE((SELECT AVG(r.rating) FROM Review r WHERE r.productId = p.id), NULL) + 1, p.sales, p.stock, c.name)
            FROM Product p
            JOIN Vendor v ON p.vendorId = v.id
            JOIN Category c ON p.categoryId = c.id
            WHERE p.id = :id
            """)
    ProductDTO getDTOFromId(@Param("id") Long id);

    // searches without cat or vendor specified
    @Query(value="""
            SELECT
                new com.panic.sasserver.dto.ProductDTO(p.name, v.name, p.id, p.vendorId, p.price, p.description, p.categoryId,
                ar.avgRating + 1, p.sales, p.stock, c.name)
            FROM
                Product p
            JOIN
                Vendor v ON p.vendorId = v.id
            JOIN
                Category c ON p.categoryId = c.id
            LEFT JOIN (
                    SELECT r.productId AS pId, AVG(r.rating) AS avgRating
                    FROM Review r
                    GROUP BY r.productId
                ) ar ON ar.pId = p.id
            WHERE
                (   LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))
                    OR LOWER(v.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))
                    OR LOWER(c.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))
                )
                AND (:minPrice IS NULL OR p.price >= :minPrice)
                AND (:maxPrice IS NULL OR p.price <= :maxPrice)
            """)
    List<ProductDTO> getDTOListFromSearchTerm(@Param("searchTerm") String searchTerm,
                                              @Param("minPrice") Double minPrice,
                                              @Param("maxPrice") Double maxPrice,
                                              Pageable pageable);


    // search with vendor filter
    @Query(value = """
            SELECT
                new com.panic.sasserver.dto.ProductDTO(p.name, v.name, p.id, p.vendorId, p.price, p.description, p.categoryId,
                ar.avgRating + 1, p.sales, p.stock, c.name)
            FROM
                Product p
            JOIN
                Vendor v ON p.vendorId = v.id
            JOIN
                Category c ON p.categoryId = c.id
            LEFT JOIN (
                    SELECT r.productId AS pId, AVG(r.rating) AS avgRating
                    FROM Review r
                    GROUP BY r.productId
                ) ar ON ar.pId = p.id
            WHERE
                v.name = :vendorName
            AND (
                (
                    LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))
                    OR LOWER(c.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))
                )
                AND (:minPrice IS NULL OR p.price >= :minPrice)
                AND (:maxPrice IS NULL OR p.price <= :maxPrice)
            )
            ORDER BY p.id
            """)
    List<ProductDTO> getDTOListByVendor( @Param("searchTerm") String searchTerm, @Param("vendorName") String vendorName,
                                         @Param("minPrice") Double minPrice,
                                         @Param("maxPrice") Double maxPrice,
                                         Pageable pageable);

    // search with category filter
    @Query(value = """
            SELECT
                new com.panic.sasserver.dto.ProductDTO(p.name, v.name, p.id, p.vendorId, p.price, p.description, p.categoryId,
                ar.avgRating + 1, p.sales, p.stock, c.name)
            FROM
                Product p
            JOIN
                Vendor v ON p.vendorId = v.id
            JOIN
                Category c ON p.categoryId = c.id
            LEFT JOIN (
                    SELECT r.productId AS pId, AVG(r.rating) AS avgRating
                    FROM Review r
                    GROUP BY r.productId
                ) ar ON ar.pId = p.id
            WHERE
                (   LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))
                    OR LOWER(v.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))
                )
                AND (
                    c.name = :categoryName
                    OR c.parentId IN (
                        SELECT c2.id
                        FROM Category c2
                        WHERE c2.parentId = (
                            SELECT c3.id
                            FROM Category c3
                            WHERE c3.name = :categoryName
                        )
                    )
                )
                AND (:minPrice IS NULL OR p.price >= :minPrice)
                AND (:maxPrice IS NULL OR p.price <= :maxPrice)
            """)
    List<ProductDTO> getDTOListByCategory( @Param("searchTerm") String searchTerm, @Param("categoryName") String categoryName,
                                           @Param("minPrice") Double minPrice,
                                           @Param("maxPrice") Double maxPrice,
                                           Pageable pageable);

    //search with category and vendor
    @Query(value = """
            SELECT
                new com.panic.sasserver.dto.ProductDTO(p.name, v.name, p.id, p.vendorId, p.price, p.description, p.categoryId,
                ar.avgRating + 1, p.sales, p.stock, c.name)
            FROM
                Product p
            JOIN
                Vendor v ON p.vendorId = v.id
            JOIN
                Category c ON p.categoryId = c.id
            LEFT JOIN (
                    SELECT r.productId AS pId, AVG(r.rating) AS avgRating
                    FROM Review r
                    GROUP BY r.productId
                ) ar ON ar.pId = p.id
            WHERE
                v.name = :vendorName
                AND (
                    c.name = :categoryName
                    OR c.parentId IN (
                        SELECT c2.id
                        FROM Category c2
                        WHERE c2.parentId = (
                            SELECT c3.id
                            FROM Category c3
                            WHERE c3.name = :categoryName
                        )
                    )
                )
                AND LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))
                AND (:minPrice IS NULL OR p.price >= :minPrice)
                AND (:maxPrice IS NULL OR p.price <= :maxPrice)
            
            """)
    List<ProductDTO> getDTOListByVendorAndCategory( @Param("searchTerm") String searchTerm, @Param("vendorName") String vendorName,
                                                    @Param("categoryName") String categoryName,
                                                    @Param("minPrice") Double minPrice,
                                                    @Param("maxPrice") Double maxPrice,
                                                    Pageable pageable);

}

