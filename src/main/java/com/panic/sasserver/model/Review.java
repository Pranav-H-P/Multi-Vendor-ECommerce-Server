package com.panic.sasserver.model;

import com.panic.sasserver.enums.Rating;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
public class Review{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        Long productId;
        Long userId;
        Rating rating;
        String comment;
        LocalDate reviewDate;


        public Review(Long productId, Long userId, Rating rating, String comment, LocalDate reviewDate) {
                this.productId = productId;
                this.userId = userId;
                this.rating = rating;
                this.comment = comment;
                this.reviewDate = reviewDate;
        }

}
