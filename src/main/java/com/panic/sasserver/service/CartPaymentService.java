package com.panic.sasserver.service;


import com.panic.sasserver.dto.CartItemDTO;
import com.panic.sasserver.dto.OrderDTO;
import com.panic.sasserver.enums.OrderStatus;
import com.panic.sasserver.model.CartItem;
import com.panic.sasserver.model.CustOrder;
import com.panic.sasserver.repository.CartRepository;
import com.panic.sasserver.repository.OrderRepository;
import com.panic.sasserver.repository.PaymentRepository;
import com.panic.sasserver.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
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

    @Transactional
    @Modifying
    public boolean cartToPaymentOrder(List<CartItemDTO> cList, String address){

        try {
            for (CartItemDTO c : cList) {

                CustOrder nOrder = new CustOrder(
                        c.getUserId(), c.getProduct().getProductId(), c.getQuantity() + " Units",
                        c.getProduct().getPrice() * c.getQuantity(), OrderStatus.PLACED, LocalDate.now(),
                        address
                );

                orderDB.save(nOrder);

            }


            return true;

        }catch (Exception e){
            return false;
        }
    }

    public List<OrderDTO> getAllOrders(Long userId, Integer pageNo, Integer perPage){
        Pageable pageable = PageRequest.of(pageNo, perPage);

        List<CustOrder> orderItems = orderDB.findAllOrdersById(userId, pageable);
        List<OrderDTO> dtoList = new ArrayList<>();

        for (CustOrder c: orderItems){

            OrderDTO cd = new OrderDTO(c,
                    productDB.getDTOFromId(c.getProductId()).getProductName());
            dtoList.add(cd);
        }

        return dtoList;
    }

    public boolean deleteCartItem(CartItemDTO item){ //deletion only happens from cart page, all details and more present
        try{
            cartDB.deleteById(item.getCartId());
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public boolean checkIfPurchased(Long userId, Long productId){
        List<CustOrder> results = orderDB.findIfProductExists(userId, productId);

        if (results.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    @Transactional
    public boolean clearCart(Long id){
        try{

            cartDB.deleteAllByUserId(id);

            return true;
        }catch (Exception e){
            return false;
        }


    }

    public List<CartItemDTO> getAllCartItems(Long currentUserId) {

        List<CartItem> cartItems = cartDB.findAllByUser(currentUserId);

        List<CartItemDTO> dtoList= new ArrayList<>();

        for (CartItem c: cartItems){

            CartItemDTO cd = new CartItemDTO(c.getId(), c.getUserId(),
                    productDB.getDTOFromId(c.getProductId()),c.getQuantity(), c.getDateAdded());

            dtoList.add(cd);
        }

        return dtoList;
    }
}
