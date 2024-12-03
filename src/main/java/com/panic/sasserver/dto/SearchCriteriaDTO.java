package com.panic.sasserver.dto;

import com.panic.sasserver.enums.SearchSortOrder;
import lombok.Data;

import java.util.Map;

@Data
public class SearchCriteriaDTO {
    String searchTerm;
    String vendor;
    String category;
    Double minPrice;
    Double maxPrice;
    SearchSortOrder order;
}
