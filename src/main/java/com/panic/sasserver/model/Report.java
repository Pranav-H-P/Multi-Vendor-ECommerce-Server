package com.panic.sasserver.model;

import com.panic.sasserver.enums.ReportType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
public class Report{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        Long vendorId;
        @Enumerated
        ReportType type;
        @NotBlank
        String data;
        LocalDate generatedDate;

        public Report(Long vendorId, ReportType type, String data, LocalDate generatedDate) {
                this.vendorId = vendorId;
                this.type = type;
                this.data = data;
                this.generatedDate = generatedDate;
        }


}
