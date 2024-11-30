package com.panic.sasserver.model;

import com.panic.sasserver.enums.VendorStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
public record Vendor(
        @Id
        Long id,
        @NotBlank
        String name,
        @NotBlank
        String contactDetails,
        VendorStatus approvalStatus,
        LocalDate joinDate
) {
}
