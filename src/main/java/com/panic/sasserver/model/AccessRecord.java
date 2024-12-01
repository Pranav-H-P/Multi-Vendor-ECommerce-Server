package com.panic.sasserver.model;

import com.panic.sasserver.enums.ActivityType;
import com.panic.sasserver.enums.DeviceType;
import jakarta.persistence.*;
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
        @Enumerated
        DeviceType type;
        LocalDateTime lastAccessed;
        @Enumerated
        ActivityType activity;


        public AccessRecord(Long userId, DeviceType type, LocalDateTime lastAccessed, ActivityType activity) {
                this.userId = userId;
                this.type = type;
                this.lastAccessed = lastAccessed;
                this.activity = activity;
        }

}
