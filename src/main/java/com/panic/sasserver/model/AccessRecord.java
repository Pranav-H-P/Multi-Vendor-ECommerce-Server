package com.panic.sasserver.model;

import com.panic.sasserver.enums.ActivityType;
import com.panic.sasserver.enums.DeviceType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class AccessRecord{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        Long userId;
        DeviceType type;
        LocalDateTime lastAccessed;
        ActivityType activity;

        public AccessRecord() {
        }

        public AccessRecord(Long userId, DeviceType type, LocalDateTime lastAccessed, ActivityType activity) {
                this.userId = userId;
                this.type = type;
                this.lastAccessed = lastAccessed;
                this.activity = activity;
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

        public DeviceType getType() {
                return type;
        }

        public void setType(DeviceType type) {
                this.type = type;
        }

        public LocalDateTime getLastAccessed() {
                return lastAccessed;
        }

        public void setLastAccessed(LocalDateTime lastAccessed) {
                this.lastAccessed = lastAccessed;
        }

        public ActivityType getActivity() {
                return activity;
        }

        public void setActivity(ActivityType activity) {
                this.activity = activity;
        }
}
