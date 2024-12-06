package com.panic.sasserver.dto;

import com.panic.sasserver.enums.SearchSortOrder;
import lombok.Data;

@Data
public class ReviewCriteriaDTO {
    Long productId;
    SearchSortOrder timeOrder;
    SearchSortOrder ratingOrder;
    Integer pageNumber;
    Integer perPage;
}
