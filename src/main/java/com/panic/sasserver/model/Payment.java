package com.panic.sasserver.model;

import com.panic.sasserver.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
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



}
