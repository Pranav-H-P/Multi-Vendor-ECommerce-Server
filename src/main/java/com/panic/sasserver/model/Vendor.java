package com.panic.sasserver.model;

import com.panic.sasserver.enums.VendorStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
public class Vendor{
        @Id
        Long id;
        @NotBlank
        String name;
        @NotBlank
        String contactDetails;
        VendorStatus approvalStatus;
        LocalDate joinDate;

        public Vendor(String name, String contactDetails, VendorStatus approvalStatus, LocalDate joinDate) {
                this.name = name;
                this.contactDetails = contactDetails;
                this.approvalStatus = approvalStatus;
                this.joinDate = joinDate;
        }

        public Vendor() {
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getContactDetails() {
                return contactDetails;
        }

        public void setContactDetails(String contactDetails) {
                this.contactDetails = contactDetails;
        }

        public VendorStatus getApprovalStatus() {
                return approvalStatus;
        }

        public void setApprovalStatus(VendorStatus approvalStatus) {
                this.approvalStatus = approvalStatus;
        }

        public LocalDate getJoinDate() {
                return joinDate;
        }

        public void setJoinDate(LocalDate joinDate) {
                this.joinDate = joinDate;
        }
}
