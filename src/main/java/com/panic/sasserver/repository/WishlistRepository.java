package com.panic.sasserver.repository;

import com.panic.sasserver.dto.ProductDTO;
import com.panic.sasserver.model.Product;
import com.panic.sasserver.model.WishlistItem;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepository extends JpaRepository<WishlistItem, Long> {

    @Transactional
    @Override
    <S extends WishlistItem> S save(S entity);

    @Transactional
    @Modifying
    @Query("DELETE FROM WishlistItem w WHERE w.userId = :userId AND w.id = :productId")
    Integer deleteByUserIdProductId(@Param("userId") Long userId,@Param("productId") Long productId);

    @Query("""
        SELECT
                new com.panic.sasserver.dto.ProductDTO(p.name, v.name, p.id, p.vendorId, p.price, p.description, p.categoryId,
                ar.avgRating + 1, p.sales, p.stock, c.name)
            FROM
                Product p
            JOIN
                Vendor v ON p.vendorId = v.id
            JOIN
                Category c ON p.categoryId = c.id
            JOIN
                WishlistItem w ON p.id = w.productId
            LEFT JOIN (
                    SELECT r.productId AS pId, AVG(r.rating) AS avgRating
                    FROM Review r
                    GROUP BY r.productId
            ) ar ON ar.pId = p.id
            WHERE w.userId = :userId
    """)
    List<ProductDTO> getAllProductsInWishlist(@Param("userId") Long userId, Pageable pageable);

    @Query("SELECT w FROM WishlistItem w WHERE w.userId = :userId AND w.productId = :productId")
    WishlistItem existByProdUserId(@Param("userId") Long userId,@Param("productId") Long productId);
}
