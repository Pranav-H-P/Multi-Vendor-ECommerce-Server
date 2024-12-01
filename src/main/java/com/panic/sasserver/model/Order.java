package com.panic.sasserver.model;

import com.panic.sasserver.enums.OrderStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
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

        public Order(Long userId, Long vendorId, String details, Integer amount, OrderStatus status, LocalDate orderDate) {
                this.userId = userId;
                this.vendorId = vendorId;
                this.details = details;
                this.amount = amount;
                this.status = status;
                this.orderDate = orderDate;
        }

}
