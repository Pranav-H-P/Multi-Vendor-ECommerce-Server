package com.panic.sasserver.model;

import com.panic.sasserver.enums.ReportType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
public record Report(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        Long vendorId,
        ReportType type,
        @NotBlank
        String data,
        LocalDate generatedDate
) {
}
