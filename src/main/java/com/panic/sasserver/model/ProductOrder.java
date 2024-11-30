package com.panic.sasserver.model;

import com.panic.sasserver.enums.OrderStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

@Entity
public record ProductOrder(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        Long userId,
        Long vendorId,
        @NotBlank
        String details,
        @PositiveOrZero
        Integer amount,
        OrderStatus status,
        LocalDate orderDate
) {
}
