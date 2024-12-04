package com.panic.sasserver.repository;

import com.panic.sasserver.dto.ReviewDTO;
import com.panic.sasserver.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("""
            SELECT new com.panic.sasserver.dto.ReviewDTO(r.id, r.productId, r.userId, u.name, r.rating, r.comment, r.reviewDate)
            FROM Review r
            JOIN
                AppUser u ON r.userId = u.id
            WHERE r.productId = :productId
            """)
    List<ReviewDTO> getReviewDTOByProductId(@Param("productId") Long productId);

    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.productId = :productId")
    Double findAverageRatingByProductId(@Param("productId") Long productId);
}
