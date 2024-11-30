package com.panic.sasserver.model;

import com.panic.sasserver.enums.ActivityType;
import com.panic.sasserver.enums.DeviceType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public record AccessRecord(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        Long userId,
        DeviceType type,
        LocalDateTime lastAccessed,
        ActivityType activity
) {
}
