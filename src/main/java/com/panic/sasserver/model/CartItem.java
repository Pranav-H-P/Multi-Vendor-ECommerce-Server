package com.panic.sasserver.model;

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



}
