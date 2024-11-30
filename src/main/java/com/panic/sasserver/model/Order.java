package com.panic.sasserver.model;

import com.panic.sasserver.enums.OrderStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

@Entity
public class Order{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        Long userId;
        Long vendorId;
        @NotBlank
        String details;
        @PositiveOrZero
        Integer amount;
        OrderStatus status;
        LocalDate orderDate;

        public Order() {
        }

        public Order(Long userId, Long vendorId, String details, Integer amount, OrderStatus status, LocalDate orderDate) {
                this.userId = userId;
                this.vendorId = vendorId;
                this.details = details;
                this.amount = amount;
                this.status = status;
                this.orderDate = orderDate;
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

        public Long getVendorId() {
                return vendorId;
        }

        public void setVendorId(Long vendorId) {
                this.vendorId = vendorId;
        }

        public String getDetails() {
                return details;
        }

        public void setDetails(String details) {
                this.details = details;
        }

        public Integer getAmount() {
                return amount;
        }

        public void setAmount(Integer amount) {
                this.amount = amount;
        }

        public OrderStatus getStatus() {
                return status;
        }

        public void setStatus(OrderStatus status) {
                this.status = status;
        }

        public LocalDate getOrderDate() {
                return orderDate;
        }

        public void setOrderDate(LocalDate orderDate) {
                this.orderDate = orderDate;
        }
}
