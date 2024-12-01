package com.panic.sasserver.model;

import com.panic.sasserver.enums.TicketStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
public class Ticket {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        Long userId;
        @NotBlank
        String issue;
        TicketStatus status;
        Long assignedToId;
        LocalDate resolutionDate;

        public Ticket(Long userId, String issue, TicketStatus status, Long assignedToId, LocalDate resolutionDate) {
                this.userId = userId;
                this.issue = issue;
                this.status = status;
                this.assignedToId = assignedToId;
                this.resolutionDate = resolutionDate;
        }

}
