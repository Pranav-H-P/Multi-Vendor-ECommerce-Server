package com.panic.sasserver.service;

import com.panic.sasserver.dto.ReviewDTO;
import com.panic.sasserver.model.Review;
import com.panic.sasserver.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewSearchService {


    @Autowired
    ReviewRepository reviewDB;


    public List<ReviewDTO> findByProductId(Long id){
        return reviewDB.getReviewDTOByProductId(id);
    }

    public Double getAverageRatingById(Long id){
        return 1.0 + reviewDB.findAverageRatingByProductId(id); // 0-4
    }

}
