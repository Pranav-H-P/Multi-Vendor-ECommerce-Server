package com.panic.sasserver.service;


import com.panic.sasserver.dto.CartItemDTO;
import com.panic.sasserver.model.CartItem;
import com.panic.sasserver.model.CustOrder;
import com.panic.sasserver.repository.CartRepository;
import com.panic.sasserver.repository.OrderRepository;
import com.panic.sasserver.repository.PaymentRepository;
import com.panic.sasserver.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartPaymentService {

    @Autowired
    CartRepository cartDB;

    @Autowired
    OrderRepository orderDB;

    @Autowired
    PaymentRepository paymemtDB;

    @Autowired
    ProductRepository productDB;

    public CartItem addToCart(Long userId, Long productId, Integer quantity, LocalDate dateAdded){ // adding happens from store page, less info at hand

        return cartDB.save(new CartItem(userId, productId, quantity, dateAdded));
    }


    public boolean deleteCartItem(CartItemDTO item){ //deletion only happens from cart page, all details and more present
        try{
            cartDB.deleteById(item.getCartId());
            return true;
        }catch (Exception e){
            return false;
        }

    }


    public List<CartItemDTO> getAllCartItems(Long currentUserId) {




        List<CartItem> cartItems = cartDB.findAllByUser(currentUserId);
        System.out.println(cartItems);
        List<CartItemDTO> dtoList= new ArrayList<>();

        for (CartItem c: cartItems){

            CartItemDTO cd = new CartItemDTO(c.getId(), c.getUserId(),
                    productDB.getDTOFromId(c.getProductId()),c.getQuantity(), c.getDateAdded());

            dtoList.add(cd);
            System.out.println(dtoList);
        }

        return dtoList;
    }
}
