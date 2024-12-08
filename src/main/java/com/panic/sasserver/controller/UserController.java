package com.panic.sasserver.controller;

import com.panic.sasserver.dto.CartItemDTO;
import com.panic.sasserver.dto.OrderDTO;
import com.panic.sasserver.dto.ProductDTO;
import com.panic.sasserver.model.CartItem;
import com.panic.sasserver.model.Product;
import com.panic.sasserver.model.Review;
import com.panic.sasserver.model.WishlistItem;
import com.panic.sasserver.repository.ReviewRepository;
import com.panic.sasserver.service.CartPaymentService;
import com.panic.sasserver.service.CustomUserDetailService;
import com.panic.sasserver.service.WishListService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/api/customer")
@PreAuthorize("isAuthenticated()")
public class UserController {

    @Autowired
    private CustomUserDetailService userDetailService;

    @Autowired
    private WishListService wishListService;

    @Autowired
    private ReviewRepository reviewDB; // only gonna be used for 1 function, so directly injecting

    @Autowired
    private CartPaymentService cartPaymentService;

    @PostMapping("/updateaddress")
    public ResponseEntity<String> uploadProfilePicture(@RequestBody String address){


        if (userDetailService.updateCurrentUserAddress(address) > 0){
            return ResponseEntity.ok("ok");
        }else{
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/addwishlist")
    public ResponseEntity<String> addToWishlist(@RequestBody WishlistItem item){


        if (wishListService.addToWishList(item) > 0){
            return ResponseEntity.ok("ok");
        }else{
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/removewishlist")
    public ResponseEntity<String> removeFromWishlist(@RequestBody WishlistItem item){


        if (wishListService.removeFromWishList(item) > 0){
            return ResponseEntity.ok("ok");
        }else{
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/getwishlist/{pageno}/{perpage}")
    public ResponseEntity<List<ProductDTO>> getWishlistProductsById(@PathVariable Integer pageno, @PathVariable Integer perpage) {
        List<ProductDTO> products = wishListService.getWishlistItems(userDetailService.getCurrentUserId(), pageno, perpage);

        if (!products.isEmpty()) {
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/wishlistexists/{prodid}")
    public ResponseEntity<String> checkIfItemExistsInWishlist(@PathVariable Long prodid) {
        Long count = wishListService.checkIfExists(userDetailService.getCurrentUserId(), prodid);

        if (count > 0) {
            return ResponseEntity.ok("ok");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    @PostMapping("/postreview")
    public ResponseEntity<String> postReview(@RequestBody Review review){

        reviewDB.save(review); // will never be null it seems

        return ResponseEntity.ok("ok");

    }

    @Transactional
    @PostMapping("/addtocart")
    public ResponseEntity<String> addToCart(@RequestBody CartItem item){

        cartPaymentService.addToCart(item.getUserId(), item.getProductId(), item.getQuantity(), item.getDateAdded()); // will never be null it seems

        return ResponseEntity.ok("ok");

    }

    @Transactional
    @PostMapping("/deletefromcart")
    public ResponseEntity<String> deleteCartItem(@RequestBody CartItemDTO item) {

        if (cartPaymentService.deleteCartItem(item)) {
            return ResponseEntity.ok("ok");
        } else {
            return ResponseEntity.internalServerError().build();
        }


    }
    @GetMapping("/clearcart")
    public ResponseEntity<String> clearCart(){

        if (cartPaymentService.clearCart(userDetailService.getCurrentUserId())){
            return ResponseEntity.ok("ok");
        }else{
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/getcart") // no pagination since cart is mostly smaller
    public ResponseEntity<List<CartItemDTO>> getCartItems(){

        List<CartItemDTO> result = cartPaymentService.getAllCartItems(userDetailService.getCurrentUserId());

        if (!result.isEmpty()){
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.notFound().build();
        }


    }

    @PostMapping("/placeorder")
    public ResponseEntity<String> postOrders(@RequestBody List<CartItemDTO> item) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        String address = userDetailService.getUserProfileData(userEmail).getAddress();

        if (cartPaymentService.cartToPaymentOrder(item,address)) {

            return ResponseEntity.ok("ok");
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/getorder/{pageno}/{perpage}")
    public ResponseEntity<List<OrderDTO>> getOrders(@PathVariable Integer pageno, @PathVariable Integer perpage){
        List<OrderDTO> result = cartPaymentService.getAllOrders(userDetailService.getCurrentUserId(), pageno, perpage);
        if (!result.isEmpty()){
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/purchased/{prodid}")
    public ResponseEntity<String> checkIfPurchased(@PathVariable Long prodid){


        if (cartPaymentService.checkIfPurchased(userDetailService.getCurrentUserId(), prodid)){
            return ResponseEntity.ok("ok");
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}

