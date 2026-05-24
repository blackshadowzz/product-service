package com.mango.productservice.dto.response;

import com.mango.productservice.entities.CategoryEntity;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private  int id;
    private String productName;
    private String Description;
    private Double price;
    private Double discount;
    private boolean deleted;
    private CategoryEntity category;
}
