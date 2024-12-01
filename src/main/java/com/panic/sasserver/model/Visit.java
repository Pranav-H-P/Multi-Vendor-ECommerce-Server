package com.panic.sasserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Visit{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        Long productId;
        Long vendorId;


        public Visit(Long productId, Long vendorId) {
                this.productId = productId;
                this.vendorId = vendorId;
        }


}
