package com.panic.sasserver.service;

import com.panic.sasserver.dto.ProductDTO;
import com.panic.sasserver.dto.ReviewCriteriaDTO;
import com.panic.sasserver.dto.ReviewDTO;
import com.panic.sasserver.model.Review;
import com.panic.sasserver.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewSearchService {


    @Autowired
    ReviewRepository reviewDB;

    private final Integer defaultLimit = 5;

    public List<ReviewDTO> findByProductId(ReviewCriteriaDTO criteria){

        if (criteria.getPageNumber() == null){
            criteria.setPageNumber(0);
        }
        if (criteria.getPerPage() == null){
            criteria.setPerPage(defaultLimit);
        }

        Pageable pageable = PageRequest.of(criteria.getPageNumber(), criteria.getPerPage());

        return reviewDB.getReviewDTOByProductId(criteria.getId(), pageable);
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
