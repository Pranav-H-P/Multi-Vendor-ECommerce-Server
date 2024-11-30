package com.panic.sasserver.model;

import com.panic.sasserver.enums.TicketStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
public record Ticket(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        Long userId,
        @NotBlank
        String issue,
        TicketStatus status,
        Long assignedToId,
        LocalDate resolutionDate
) {
}
