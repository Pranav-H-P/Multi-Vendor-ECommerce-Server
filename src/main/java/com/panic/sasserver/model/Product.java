package com.panic.sasserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

@Entity
public class Product{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        Long vendorId;
        @NotBlank
        String name;
        @NotEmpty
        String description;
        @Positive
        Integer price;
        Long categoryId;
        @PositiveOrZero
        Integer stock;
        @NotEmpty
        String images;
        LocalDate createdDate;

        public Product() {
        }

        public Product(Long vendorId, String name, String description, Integer price, Long categoryId, Integer stock, String images, LocalDate createdDate) {
                this.vendorId = vendorId;
                this.name = name;
                this.description = description;
                this.price = price;
                this.categoryId = categoryId;
                this.stock = stock;
                this.images = images;
                this.createdDate = createdDate;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Long getVendorId() {
                return vendorId;
        }

        public void setVendorId(Long vendorId) {
                this.vendorId = vendorId;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public Integer getPrice() {
                return price;
        }

        public void setPrice(Integer price) {
                this.price = price;
        }

        public Long getCategoryId() {
                return categoryId;
        }

        public void setCategoryId(Long categoryId) {
                this.categoryId = categoryId;
        }

        public Integer getStock() {
                return stock;
        }

        public void setStock(Integer stock) {
                this.stock = stock;
        }

        public String getImages() {
                return images;
        }

        public void setImages(String images) {
                this.images = images;
        }

        public LocalDate getCreatedDate() {
                return createdDate;
        }

        public void setCreatedDate(LocalDate createdDate) {
                this.createdDate = createdDate;
        }
}
