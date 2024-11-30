package com.panic.sasserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public record Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id,
    @NotEmpty
    String name,
    @NotEmpty
    String Description,
    Long parentId
) {
}
