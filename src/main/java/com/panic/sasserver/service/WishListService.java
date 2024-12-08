package com.panic.sasserver.service;


import com.panic.sasserver.dto.ProductDTO;
import com.panic.sasserver.model.Product;
import com.panic.sasserver.model.WishlistItem;
import com.panic.sasserver.repository.WishlistRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {

    @Autowired
    WishlistRepository wishListDB;


    public Long addToWishList(WishlistItem wishlistItem){

        return wishListDB.save(wishlistItem).getId();
    }


    public Integer removeFromWishList(WishlistItem wishlistItem){
        return wishListDB.deleteByUserIdProductId(wishlistItem.getUserId(), wishlistItem.getProductId());
    }

    public Long checkIfExists(Long userId, Long productId){
        if (wishListDB.existByProdUserId(userId, productId) == null){
            return 0L;
        }
        return wishListDB.existByProdUserId(userId, productId).getId();

    }
    public List<ProductDTO> getWishlistItems(Long userId, Integer pageNo, Integer perPage){
        Pageable pageable = PageRequest.of(pageNo, perPage);

        return wishListDB.getAllProductsInWishlist(userId, pageable);
    }


}
