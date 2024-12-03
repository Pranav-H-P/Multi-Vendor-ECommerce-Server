package com.panic.sasserver.model;

import com.panic.sasserver.enums.PaymentStatus;
import jakarta.persistence.*;
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
        Double amount;
        LocalDate paymentDate;
        @Enumerated
        PaymentStatus status;

        public Payment(PaymentStatus status, LocalDate paymentDate, Double amount, Long vendorId, Long userId, Long orderId) {
                this.status = status;
                this.paymentDate = paymentDate;
                this.amount = amount;
                this.vendorId = vendorId;
                this.userId = userId;
                this.orderId = orderId;
        }



}
