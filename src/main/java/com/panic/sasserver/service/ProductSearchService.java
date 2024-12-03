package com.panic.sasserver.service;

import com.panic.sasserver.dto.ProductDTO;
import com.panic.sasserver.dto.SearchCriteriaDTO;
import com.panic.sasserver.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ProductSearchService {

    @Autowired
    private ProductRepository productDB;

    public List<ProductDTO> getProductSearch(SearchCriteriaDTO criteria){
        String searchTerm = criteria.getSearchTerm();

        List<ProductDTO> products;

        if (criteria.getVendor() != null && criteria.getCategory() != null){
            products = productDB.getDTOListByVendorAndCategory(searchTerm, criteria.getVendor(), criteria.getCategory());
        }else if (criteria.getVendor() != null){
            products = productDB.getDTOListByVendor(searchTerm, criteria.getVendor());
        }else if (criteria.getCategory() != null){
            products = productDB.getDTOListByCategory(searchTerm, criteria.getCategory());
        }else{
            products = productDB.getDTOListFromSearchTerm(searchTerm);
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

        if (criteria.getOrder() != null) {
            products = switch (criteria.getOrder()) {
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

    public List<ProductDTO> getProductSearch(String searchTerm){

        return productDB.getDTOListFromSearchTerm(searchTerm);
    }

    public ProductDTO getDTOFromId(Long id) {
        return productDB.getDTOFromId(id);
    }
}
