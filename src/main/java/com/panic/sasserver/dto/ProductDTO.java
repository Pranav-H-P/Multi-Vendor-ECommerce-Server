package com.panic.sasserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO{

    String productName;
    String vendorName;
    Long productId;
    Long vendorId;
    Double price;
    String description;
    Long categoryId;
    Double averageRating;

    public ProductDTO(String productName, String vendorName, Long productId, Long vendorId, Double price, String description, Long categoryId) {
        this.productName = productName;
        this.vendorName = vendorName;
        this.productId = productId;
        this.vendorId = vendorId;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
    }

}
