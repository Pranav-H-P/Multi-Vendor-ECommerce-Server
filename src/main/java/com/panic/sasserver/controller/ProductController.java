package com.panic.sasserver.controller;

import com.panic.sasserver.dto.ProductDTO;
import com.panic.sasserver.dto.SearchCriteriaDTO;
import com.panic.sasserver.model.Category;
import com.panic.sasserver.service.ProductSearchService;
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

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        ProductDTO product = productSearchService.getDTOFromId(id);


        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // for the simple header search
    @GetMapping("/search/{term}")
    public ResponseEntity<List<ProductDTO>> getProductBySearch(@PathVariable String term) {
        List<ProductDTO> products = productSearchService.getProductSearch(term);;

        if (!products.isEmpty()) {
            return ResponseEntity.ok(products);
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
}
