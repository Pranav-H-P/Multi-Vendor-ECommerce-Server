package com.panic.sasserver.service;

import com.panic.sasserver.dto.ProductDTO;
import com.panic.sasserver.dto.SearchCriteriaDTO;
import com.panic.sasserver.model.Category;
import com.panic.sasserver.repository.CategoryRepository;
import com.panic.sasserver.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;


@Service
public class ProductSearchService {

    @Autowired
    private ProductRepository productDB;

    @Autowired
    private CategoryRepository categoryDB;

    private final Integer defaultLimit = 5;


    public List<Category> getCategories(){
        return categoryDB.findAll();
    }

    public List<ProductDTO> getProductSearch(SearchCriteriaDTO criteria){
        String searchTerm = criteria.getSearchTerm();


        if (criteria.getPageNumber() == null){
            criteria.setPageNumber(0);
        }
        if (criteria.getPerPage() == null){
            criteria.setPerPage(defaultLimit);
        }

        Pageable pageable = PageRequest.of(criteria.getPageNumber(), criteria.getPerPage());

        List<ProductDTO> products;


        if (criteria.getVendor() != null && criteria.getCategory() != null){
            System.out.println(1);
            products = productDB.getDTOListByVendorAndCategory(searchTerm, criteria.getVendor(), criteria.getCategory(), pageable);
        }else if (criteria.getVendor() != null){
            System.out.println(2);
            products = productDB.getDTOListByVendor(searchTerm, criteria.getVendor(), pageable);
        }else if (criteria.getCategory() != null){
            System.out.println(3);
            products = productDB.getDTOListByCategory(searchTerm, criteria.getCategory(), pageable);
        }else{
            System.out.println(4);
            products = productDB.getDTOListFromSearchTerm(searchTerm, pageable);
            System.out.println(products);
        }



        if (criteria.getMinPrice() != null) {
            products = products.stream()
                    .filter(product -> product.getPrice() >= criteria.getMinPrice())
                    .toList();
        }

        if (criteria.getMaxPrice() != null) {
            products = products.stream()
                    .filter(product -> product.getPrice() <= criteria.getMaxPrice())
                    .toList();
        }

        if (criteria.getPriceOrder() != null) {
            products = switch (criteria.getPriceOrder()) {
                case ASC -> products.stream()
                        .sorted(Comparator.comparing(ProductDTO::getPrice))
                        .toList();
                case DSC -> products.stream()
                        .sorted(Comparator.comparing(ProductDTO::getPrice).reversed())
                        .toList();
                default -> products;
            };
        }
        if (criteria.getCreationOrder() != null) {
            products = switch (criteria.getCreationOrder()) {
                case ASC -> products.stream()
                        .sorted(Comparator.comparing(ProductDTO::getPrice))
                        .toList();
                case DSC -> products.stream()
                        .sorted(Comparator.comparing(ProductDTO::getPrice).reversed())
                        .toList();
                default -> products;
            };
        }


        return products;
    }

    public ProductDTO getDTOFromId(Long id) {
        return productDB.getDTOFromId(id);
    }

}
