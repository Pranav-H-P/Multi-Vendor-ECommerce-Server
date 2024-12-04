package com.panic.sasserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@NoArgsConstructor
@Data
@Entity
public class Product{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        Long vendorId;
        @NotBlank
        String name;
        @NotEmpty
        String description;
        @Positive
        Double price;
        Long categoryId;
        @PositiveOrZero
        Integer stock;
        LocalDate createdDate;

        public Product(Long vendorId, String name, String description, Double price, Long categoryId, Integer stock, LocalDate createdDate) {
                this.vendorId = vendorId;
                this.name = name;
                this.description = description;
                this.price = price;
                this.categoryId = categoryId;
                this.stock = stock;
                this.createdDate = createdDate;
        }

}
