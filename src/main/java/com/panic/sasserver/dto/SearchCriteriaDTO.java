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
    SearchSortOrder priceOrder;
    Integer pageNumber;
    Integer perPage;
    SearchSortOrder creationOrder;
}
/*

curl -X POST localhost:8080/api/product/search \
-H "Content-Type: application/json" \
-d '{
  "searchTerm": "dumbbell",
  "vendor": null,
  "category": null,
  "minPrice": null,
  "maxPrice": null,
  "priceOrder": "NONE",
  "offset": null,
  "limit": null,
  "creationOrder": "NONE"
}'


*/