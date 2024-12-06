package com.panic.sasserver.service;

import com.panic.sasserver.dto.ProductDTO;
import com.panic.sasserver.dto.ReviewCriteriaDTO;
import com.panic.sasserver.dto.ReviewDTO;
import com.panic.sasserver.enums.SearchSortOrder;
import com.panic.sasserver.model.Review;
import com.panic.sasserver.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewSearchService {


    @Autowired
    ReviewRepository reviewDB;

    private final Integer defaultLimit = 5;

    public List<ReviewDTO> findByProductId(ReviewCriteriaDTO criteria){

        List<Sort.Order> orders = new ArrayList<>();

        if (criteria.getPageNumber() == null){
            criteria.setPageNumber(0);
        }
        if (criteria.getPerPage() == null){
            criteria.setPerPage(defaultLimit);
        }

        if (criteria.getRatingOrder() != null && criteria.getRatingOrder() != SearchSortOrder.NONE) {
            if (criteria.getRatingOrder() == SearchSortOrder.ASC) {
                orders.add(Sort.Order.asc("rating"));
            } else if (criteria.getRatingOrder() == SearchSortOrder.DSC) {
                orders.add(Sort.Order.desc("rating"));
            }
        }
        if (criteria.getTimeOrder() != null && criteria.getTimeOrder() != SearchSortOrder.NONE) {
            if (criteria.getTimeOrder() == SearchSortOrder.ASC) {
                orders.add(Sort.Order.asc("reviewDate"));
            } else if (criteria.getTimeOrder() == SearchSortOrder.DSC) {
                orders.add(Sort.Order.desc("reviewDate"));
            }
        }

        Sort customSort = Sort.by(orders);

        Pageable pageable = PageRequest.of(criteria.getPageNumber(), criteria.getPerPage(), customSort);


        return reviewDB.getReviewDTOByProductId(criteria.getProductId(), pageable);
    }

    public Double getAverageRatingById(Long id){
        return 1.0 + reviewDB.findAverageRatingByProductId(id); // 0-4
    }
    public ProductDTO addAverageReviews(ProductDTO product) {


        Double averageRating = getAverageRatingById(product.getProductId());
        product.setAverageRating(averageRating);

        return product;
    }

    public List<ProductDTO> addAverageReviews(List<ProductDTO> products) {

        for (ProductDTO product : products) {
            Double averageRating = getAverageRatingById(product.getProductId());
            product.setAverageRating(averageRating);
            System.out.println(product);
        }
        return products;
    }
}
