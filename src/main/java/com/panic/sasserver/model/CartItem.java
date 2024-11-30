package com.panic.sasserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public record CartItem(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        Long userId,
        Long ProductId,
        Integer Quantity,
        LocalDate DateAdded
) {
}