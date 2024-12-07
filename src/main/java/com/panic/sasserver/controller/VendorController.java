package com.panic.sasserver.controller;


import com.panic.sasserver.dto.ProductDTO;
import com.panic.sasserver.dto.SearchCriteriaDTO;
import com.panic.sasserver.model.Vendor;
import com.panic.sasserver.repository.VendorRepository;
import com.panic.sasserver.service.ProductSearchService;
import com.panic.sasserver.service.ReviewSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/*vendor related endpoints
*
*
* /id is accessible to the public, everything else requires authorization
* */

@RestController
@RequestMapping("/api/vendor")
public class VendorController {

    @Autowired
    VendorRepository vendorDB;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Vendor>> getProductById(@PathVariable Long id) {
        Optional<Vendor> vendor = vendorDB.findById(id);

        if (vendor.isPresent()) {
            return ResponseEntity.ok(vendor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list/{pageNo}/{perPage}")
    public ResponseEntity<List<Vendor>> getProductById(@PathVariable Integer pageNo, @PathVariable Integer perPage) {

        Pageable pageable = PageRequest.of(pageNo, perPage);
        List<Vendor> vendors = vendorDB.findAll(pageable).getContent();

        if (!vendors.isEmpty()) {
            return ResponseEntity.ok(vendors);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}