package com.panic.sasserver.dto;


import com.panic.sasserver.enums.OrderStatus;
import com.panic.sasserver.model.CustOrder;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {

    Long id;
    Long userId;
    Long productId;
    String details;
    Double amount;
    OrderStatus status;
    LocalDate orderDate;
    String address;
    String productName;

    public OrderDTO(CustOrder c, String pName){
        productName = pName;
        id = c.getId();
        userId = c.getUserId();
        productId = c.getProductId();
        details = c.getDetails();
        amount = c.getAmount();
        status = c.getStatus();
        orderDate = c.getOrderDate();
        address = c.getAddress();
    }

}
