package com.mango.productservice.dto.request;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDtoCreate {
    private String categoryName;
    private String description;
    private boolean isActive;
}
