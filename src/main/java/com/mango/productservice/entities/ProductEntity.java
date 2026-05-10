package com.mango.productservice.entities;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    private  int id;
    private String productName;
    private String Description;
    private Double price;
    private Double discount;
}
