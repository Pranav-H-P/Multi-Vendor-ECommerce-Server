package com.panic.sasserver.model;

import com.panic.sasserver.enums.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
public class CustOrder{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        Long userId;
        Long productId;
        @NotBlank
        String details;
        @PositiveOrZero
        Double amount;
        @Enumerated
        OrderStatus status;
        LocalDate orderDate;
        @NotBlank
        String address;

        public CustOrder(Long userId, Long productId, String details, Double amount, OrderStatus status, LocalDate orderDate, String address) {
                this.userId = userId;
                this.productId = productId;
                this.details = details;
                this.amount = amount;
                this.status = status;
                this.orderDate = orderDate;
                this.address = address;
        }

}
