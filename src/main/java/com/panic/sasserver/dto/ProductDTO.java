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

}
