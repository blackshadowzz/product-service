package com.mango.productservice.dto.request;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDtoUpdate {
    private int id;
    private String categoryName;
    private String description;
    private boolean isActive;
}