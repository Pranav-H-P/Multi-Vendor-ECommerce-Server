package com.panic.sasserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class CartItem{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        Long userId;
        Long ProductId;
        Integer Quantity;
        LocalDate DateAdded;

        public CartItem(Long userId, Long productId, Integer quantity, LocalDate dateAdded) {
                this.userId = userId;
                ProductId = productId;
                Quantity = quantity;
                DateAdded = dateAdded;
        }

        public CartItem() {
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
                return ProductId;
        }

        public void setProductId(Long productId) {
                ProductId = productId;
        }

        public Integer getQuantity() {
                return Quantity;
        }

        public void setQuantity(Integer quantity) {
                Quantity = quantity;
        }

        public LocalDate getDateAdded() {
                return DateAdded;
        }

        public void setDateAdded(LocalDate dateAdded) {
                DateAdded = dateAdded;
        }
}
