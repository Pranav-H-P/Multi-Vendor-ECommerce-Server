package com.panic.sasserver.controller;

import com.panic.sasserver.dto.ProductDTO;
import com.panic.sasserver.dto.ReviewCriteriaDTO;
import com.panic.sasserver.dto.ReviewDTO;
import com.panic.sasserver.dto.SearchCriteriaDTO;
import com.panic.sasserver.model.Category;
import com.panic.sasserver.service.ProductSearchService;
import com.panic.sasserver.service.ReviewSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
 * product related stuff
 * */


@RestController
@RequestMapping("/api/product")

public class ProductController {

    @Autowired
    private ProductSearchService productSearchService;

    @Autowired
    private ReviewSearchService reviewSearchService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        ProductDTO product = productSearchService.getDTOFromId(id);

        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/search")
    public ResponseEntity<List<ProductDTO>> getProductBySearch(@RequestBody SearchCriteriaDTO criteria) {
        List<ProductDTO> products = productSearchService.getProductSearch(criteria);


        if (!products.isEmpty()) {
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = productSearchService.getCategories();

        if (!categories.isEmpty()){
            return ResponseEntity.ok(categories);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{productId}/rating") // for getting total rating of item
    public ResponseEntity<Double> GetOverallRating(@PathVariable Long productId){
        Double rating = reviewSearchService.getAverageRatingById(productId);

        if (rating != null) {
            return ResponseEntity.ok(rating);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/review") // for getting all user reviews for a given product
    public ResponseEntity<List<ReviewDTO>> getProductReviews(@RequestBody ReviewCriteriaDTO criteria){

        List<ReviewDTO> reviews = reviewSearchService.findByProductId(criteria);

        if (!reviews.isEmpty()) {
            return ResponseEntity.ok(reviews);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
