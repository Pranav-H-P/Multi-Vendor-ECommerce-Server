package com.panic.sasserver.model;

import com.panic.sasserver.enums.Rating;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

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

        public Review() {
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Long getProductId() {
                return productId;
        }

        public void setProductId(Long productId) {
                this.productId = productId;
        }

        public Long getUserId() {
                return userId;
        }

        public void setUserId(Long userId) {
                this.userId = userId;
        }

        public Rating getRating() {
                return rating;
        }

        public void setRating(Rating rating) {
                this.rating = rating;
        }

        public String getComment() {
                return comment;
        }

        public void setComment(String comment) {
                this.comment = comment;
        }

        public LocalDate getReviewDate() {
                return reviewDate;
        }

        public void setReviewDate(LocalDate reviewDate) {
                this.reviewDate = reviewDate;
        }
}
