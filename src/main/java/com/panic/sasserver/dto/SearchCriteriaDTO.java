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
    SearchSortOrder ratingOrder;
    SearchSortOrder salesOrder;
    SearchSortOrder stockOrder;
}
/*

curl -X POST \
  http://localhost:8080/api/product/search \
  -H "Content-Type: application/json" \
  -d '{
    "searchTerm": "dumb",
    "vendor": null,
    "category": null,
    "minPrice": 700.0,
    "maxPrice": 2000.0,
    "priceOrder": null,
    "pageNumber": 0,
    "perPage": 10,
    "creationOrder": null,
    "ratingOrder" :null,
    "salesOrder": null,
    "stockOrder": "ASC"
  }'
*/