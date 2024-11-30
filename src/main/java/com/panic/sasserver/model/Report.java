package com.panic.sasserver.model;

import com.panic.sasserver.enums.ReportType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
public class Report{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        Long vendorId;
        ReportType type;
        @NotBlank
        String data;
        LocalDate generatedDate;

        public Report() {
        }

        public Report(Long vendorId, ReportType type, String data, LocalDate generatedDate) {
                this.vendorId = vendorId;
                this.type = type;
                this.data = data;
                this.generatedDate = generatedDate;
        }

        public Long getVendorId() {
                return vendorId;
        }

        public void setVendorId(Long vendorId) {
                this.vendorId = vendorId;
        }

        public ReportType getType() {
                return type;
        }

        public void setType(ReportType type) {
                this.type = type;
        }

        public String getData() {
                return data;
        }

        public void setData(String data) {
                this.data = data;
        }

        public LocalDate getGeneratedDate() {
                return generatedDate;
        }

        public void setGeneratedDate(LocalDate generatedDate) {
                this.generatedDate = generatedDate;
        }
}
