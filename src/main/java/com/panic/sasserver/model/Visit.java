package com.panic.sasserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public record Visit(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        long productId,
        long vendorId
) {
}
