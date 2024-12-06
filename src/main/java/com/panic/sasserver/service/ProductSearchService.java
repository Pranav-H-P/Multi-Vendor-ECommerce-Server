package com.panic.sasserver.service;

import com.panic.sasserver.dto.ProductDTO;
import com.panic.sasserver.dto.SearchCriteriaDTO;
import com.panic.sasserver.enums.SearchSortOrder;
import com.panic.sasserver.model.Category;
import com.panic.sasserver.repository.CategoryRepository;
import com.panic.sasserver.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        List<Sort.Order> orders = new ArrayList<>();

        if (criteria.getPageNumber() == null){
            criteria.setPageNumber(0);
        }
        if (criteria.getPerPage() == null){
            criteria.setPerPage(defaultLimit);
        }

        // filters

        if (criteria.getPriceOrder() != null && criteria.getPriceOrder() != SearchSortOrder.NONE) {
            if (criteria.getPriceOrder() == SearchSortOrder.ASC) {
                orders.add(Sort.Order.asc("price"));
            } else if (criteria.getPriceOrder() == SearchSortOrder.DSC) {
                orders.add(Sort.Order.desc("price"));
            }
        }
        if (criteria.getRatingOrder() != null && criteria.getRatingOrder() != SearchSortOrder.NONE){
            if (criteria.getRatingOrder() == SearchSortOrder.ASC) {
                orders.add(Sort.Order.asc("ar.avgRating"));
            } else if (criteria.getRatingOrder() == SearchSortOrder.DSC) {
                orders.add(Sort.Order.desc( "ar.avgRating"));
            }
        }
        if (criteria.getSalesOrder() != null && criteria.getSalesOrder() != SearchSortOrder.NONE){
            if (criteria.getSalesOrder() == SearchSortOrder.ASC) {
                orders.add(Sort.Order.asc("sales"));
            } else if (criteria.getSalesOrder() == SearchSortOrder.DSC) {
                orders.add(Sort.Order.desc( "sales"));
            }
        }
        if (criteria.getCreationOrder() != null && criteria.getCreationOrder() != SearchSortOrder.NONE){
            if (criteria.getCreationOrder() == SearchSortOrder.ASC) {
                orders.add(Sort.Order.asc("createdDate"));
            } else if (criteria.getCreationOrder() == SearchSortOrder.DSC) {
                orders.add(Sort.Order.desc( "createdDate"));
            }
        }

        if (criteria.getStockOrder() != null && criteria.getStockOrder() != SearchSortOrder.NONE){
            if (criteria.getStockOrder() == SearchSortOrder.ASC) {
                orders.add(Sort.Order.asc("stock"));
            } else if (criteria.getStockOrder() == SearchSortOrder.DSC) {
                orders.add(Sort.Order.desc( "stock"));
            }
        }

        Sort customSort = Sort.by(orders);

        Pageable pageable = PageRequest.of(criteria.getPageNumber(), criteria.getPerPage(), customSort);

        List<ProductDTO> products;

        if (criteria.getVendor() != null && criteria.getCategory() != null){
            products = productDB.getDTOListByVendorAndCategory(searchTerm, criteria.getVendor(), criteria.getCategory(),
                    criteria.getMinPrice(),
                    criteria.getMaxPrice(),
                    pageable);
        }else if (criteria.getVendor() != null){
            products = productDB.getDTOListByVendor(searchTerm, criteria.getVendor(),
                    criteria.getMinPrice(),
                    criteria.getMaxPrice(),
                    pageable);
        }else if (criteria.getCategory() != null){
            products = productDB.getDTOListByCategory(searchTerm, criteria.getCategory(),
                    criteria.getMinPrice(),
                    criteria.getMaxPrice(),
                    pageable);
        }else{
            products = productDB.getDTOListFromSearchTerm(searchTerm,
                    criteria.getMinPrice(),
                    criteria.getMaxPrice(),
                    pageable);
        }


        /*
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
        }*/


        return products;
    }

    public ProductDTO getDTOFromId(Long id) {
        return productDB.getDTOFromId(id);
    }

}
