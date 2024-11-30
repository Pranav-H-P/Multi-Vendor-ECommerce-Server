package com.panic.sasserver.model;

import com.panic.sasserver.enums.Rating;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public record Review(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        Long productId,
        Long userId,
        Rating rating,
        String comment,
        LocalDate reviewDate
) {
}
