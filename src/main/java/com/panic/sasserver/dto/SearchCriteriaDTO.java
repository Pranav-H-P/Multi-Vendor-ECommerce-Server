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
"searchTerm": "",
"vendor": null,
"category": "Dumbbells",
"minPrice": 500.0,

}'
*/