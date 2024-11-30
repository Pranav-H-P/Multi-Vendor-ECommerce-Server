package com.panic.sasserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

@Entity
public record Product(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        Long vendorId,
        @NotBlank
        String name,
        @NotEmpty
        String description,
        @Positive
        Integer price,
        Long categoryId,
        @PositiveOrZero
        Integer stock,
        @NotEmpty
        String images,
        LocalDate createdDate
) {
}
