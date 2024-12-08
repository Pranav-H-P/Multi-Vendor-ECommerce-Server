package com.panic.sasserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDTO {
    Long cartId;
    Long userId;
    ProductDTO product;
    Integer quantity;
    LocalDate dateAdded;


}
