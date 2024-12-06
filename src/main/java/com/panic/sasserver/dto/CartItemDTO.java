package com.panic.sasserver.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CartItemDTO {
    Long userId;
    ProductDTO product;
    Integer quantity;
    Date dateAdded;
}
