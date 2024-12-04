package com.panic.sasserver.dto;


import com.panic.sasserver.enums.Rating;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    Long id;
    Long productId;
    Long userId;
    String userName;
    Rating rating;
    String comment;
    LocalDate reviewDate;
}
