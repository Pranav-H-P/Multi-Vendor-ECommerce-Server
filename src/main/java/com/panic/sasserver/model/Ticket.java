package com.panic.sasserver.model;

import com.panic.sasserver.enums.TicketStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

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

        public Ticket() {
        }

        public Ticket(Long userId, String issue, TicketStatus status, Long assignedToId, LocalDate resolutionDate) {
                this.userId = userId;
                this.issue = issue;
                this.status = status;
                this.assignedToId = assignedToId;
                this.resolutionDate = resolutionDate;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Long getUserId() {
                return userId;
        }

        public void setUserId(Long userId) {
                this.userId = userId;
        }

        public String getIssue() {
                return issue;
        }

        public void setIssue(String issue) {
                this.issue = issue;
        }

        public TicketStatus getStatus() {
                return status;
        }

        public void setStatus(TicketStatus status) {
                this.status = status;
        }

        public Long getAssignedToId() {
                return assignedToId;
        }

        public void setAssignedToId(Long assignedToId) {
                this.assignedToId = assignedToId;
        }

        public LocalDate getResolutionDate() {
                return resolutionDate;
        }

        public void setResolutionDate(LocalDate resolutionDate) {
                this.resolutionDate = resolutionDate;
        }
}
