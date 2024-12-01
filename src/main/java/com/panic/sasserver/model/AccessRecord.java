package com.panic.sasserver.model;

import com.panic.sasserver.enums.ActivityType;
import com.panic.sasserver.enums.DeviceType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity
public class AccessRecord{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        Long userId;
        DeviceType type;
        LocalDateTime lastAccessed;
        ActivityType activity;


        public AccessRecord(Long userId, DeviceType type, LocalDateTime lastAccessed, ActivityType activity) {
                this.userId = userId;
                this.type = type;
                this.lastAccessed = lastAccessed;
                this.activity = activity;
        }

}
