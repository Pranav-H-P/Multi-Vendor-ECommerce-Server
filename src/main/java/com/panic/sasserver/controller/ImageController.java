package com.panic.sasserver.controller;


import com.panic.sasserver.service.FileSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {


    @Autowired
    private FileSystemService fileSystemService;

    @GetMapping("/product/{id}") // products can have multiple images stored, so this method returns all names
    public ResponseEntity<List<String>> getProductImageNames(@PathVariable Long id){
        List<String> imageNames = fileSystemService.listImages("products/" + id.toString());
        return ResponseEntity.ok(imageNames);

    }

    @GetMapping("/product/{id}/{name}") // returns specific product image
    @ResponseBody
    public ResponseEntity<Resource> getProductImage(@PathVariable Long id, @PathVariable String name){
        try {
            Resource resource = fileSystemService.getImage("products/" + id + "/" + name);

            if (!resource.exists()) {
                return ResponseEntity.notFound().build();
            }

            String contentType = Files.probeContentType(Paths.get(resource.getFile().getPath()));
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, contentType != null ? contentType : "application/octet-stream");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/user/{id}") // vendors and users have only one image stored (profile picture)
    @ResponseBody
    public ResponseEntity<Resource> getUserImages(@PathVariable String id){
        try {
            Resource resource = fileSystemService.getImage("users/" + id );

            if (!resource.exists()) {
                resource = fileSystemService.getImage("users/placeholder.jpg");
            }

            String contentType = Files.probeContentType(Paths.get(resource.getFile().getPath()));
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, contentType != null ? contentType : "application/octet-stream");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) { // file not found, return default profile image


            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();


        }
    }

}