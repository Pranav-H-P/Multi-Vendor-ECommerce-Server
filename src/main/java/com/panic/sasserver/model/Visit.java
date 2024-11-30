package com.panic.sasserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Visit{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        Long productId;
        Long vendorId;

        public Visit() {
        }

        public Visit(Long productId, Long vendorId) {
                this.productId = productId;
                this.vendorId = vendorId;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Long getProductId() {
                return productId;
        }

        public void setProductId(Long productId) {
                this.productId = productId;
        }

        public Long getVendorId() {
                return vendorId;
        }

        public void setVendorId(Long vendorId) {
                this.vendorId = vendorId;
        }
}
