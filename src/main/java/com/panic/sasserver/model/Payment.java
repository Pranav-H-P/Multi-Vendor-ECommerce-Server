package com.panic.sasserver.model;

import com.panic.sasserver.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Payment{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        Long orderId;
        Long userId;
        Long vendorId;
        Integer amount;
        LocalDate paymentDate;
        PaymentStatus status;

        public Payment(PaymentStatus status, LocalDate paymentDate, Integer amount, Long vendorId, Long userId, Long orderId) {
                this.status = status;
                this.paymentDate = paymentDate;
                this.amount = amount;
                this.vendorId = vendorId;
                this.userId = userId;
                this.orderId = orderId;
        }

        public Payment() {
        }

        public PaymentStatus getStatus() {
                return status;
        }

        public void setStatus(PaymentStatus status) {
                this.status = status;
        }

        public LocalDate getPaymentDate() {
                return paymentDate;
        }

        public void setPaymentDate(LocalDate paymentDate) {
                this.paymentDate = paymentDate;
        }

        public Integer getAmount() {
                return amount;
        }

        public void setAmount(Integer amount) {
                this.amount = amount;
        }

        public Long getVendorId() {
                return vendorId;
        }

        public void setVendorId(Long vendorId) {
                this.vendorId = vendorId;
        }

        public Long getUserId() {
                return userId;
        }

        public void setUserId(Long userId) {
                this.userId = userId;
        }

        public Long getOrderId() {
                return orderId;
        }

        public void setOrderId(Long orderId) {
                this.orderId = orderId;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }
}
