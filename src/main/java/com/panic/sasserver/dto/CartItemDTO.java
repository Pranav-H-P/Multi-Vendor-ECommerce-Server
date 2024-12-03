package com.panic.sasserver.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CartItemDTO {
    Long userId;
    Long productId;
    String productName;
    Integer quantity;
    Double price;
    Date dateAdded;
}
