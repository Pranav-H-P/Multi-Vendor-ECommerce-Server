package com.panic.sasserver.model;

import com.panic.sasserver.enums.VendorStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
public class Vendor{
        @Id
        Long id;
        @NotBlank
        String name;
        @NotBlank
        String contactDetails;
        @NotBlank
        String description;
        @Enumerated
        VendorStatus approvalStatus;
        LocalDate joinDate;

        public Vendor(Long id, String name, String contactDetails, String description, VendorStatus approvalStatus, LocalDate joinDate) {
                this.id = id;
                this.name = name;
                this.contactDetails = contactDetails;
                this.approvalStatus = approvalStatus;
                this.description = description;
                this.joinDate = joinDate;
        }

}
