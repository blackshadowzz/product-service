package com.mango.productservice.dto.response;

import lombok.*;
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    private int id;
    private String categoryName;
    private String description;
    private boolean isActive;
}

