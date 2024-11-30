package com.panic.sasserver.model;

import com.panic.sasserver.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public record Payment(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        Long orderId,
        Long userId,
        Long vendorId,
        Integer amount,
        LocalDate paymentDate,
        PaymentStatus status
) {
}
