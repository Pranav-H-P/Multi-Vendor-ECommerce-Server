package com.panic.sasserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class WishlistItem{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        Long userId;
        Long productId;
        LocalDate dateAdded;

        public WishlistItem() {
        }

        public WishlistItem(Long userId, Long productId, LocalDate dateAdded) {
                this.userId = userId;
                this.productId = productId;
                this.dateAdded = dateAdded;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Long getUserId() {
                return userId;
        }

        public void setUserId(Long userId) {
                this.userId = userId;
        }

        public Long getProductId() {
                return productId;
        }

        public void setProductId(Long productId) {
                this.productId = productId;
        }

        public LocalDate getDateAdded() {
                return dateAdded;
        }

        public void setDateAdded(LocalDate dateAdded) {
                this.dateAdded = dateAdded;
        }
}
