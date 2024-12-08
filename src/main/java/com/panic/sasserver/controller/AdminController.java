package com.panic.sasserver.controller;


import com.panic.sasserver.model.Vendor;
import com.panic.sasserver.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    VendorRepository vendorDB;

    @GetMapping("/vendorrequests")
    public ResponseEntity<List<Vendor>> getVendorRequests(){

        List<Vendor> pendingVendors = vendorDB.getPendingVendors();

        if (!pendingVendors.isEmpty()){
            return ResponseEntity.ok(pendingVendors);
        }else{
            return  ResponseEntity.notFound().build();
        }

    }
    @PostMapping("/approvevendor")
    public ResponseEntity<String> approveVendor(@RequestBody Vendor vendor){

        vendorDB.save(vendor);
        return ResponseEntity.ok("ok");
    }
}
