package com.panic.sasserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
@AllArgsConstructor
public class CartItem{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        Long userId;
        Long productId;
        Integer quantity;
        LocalDate dateAdded;

        public CartItem(Long userId, Long productId, Integer quantity, LocalDate dateAdded) {
                this.userId = userId;
                this.productId = productId;
                this.quantity = quantity;
                this.dateAdded = dateAdded;
        }



}
