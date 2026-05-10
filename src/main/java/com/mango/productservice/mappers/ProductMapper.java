package com.mango.productservice.mappers;

import com.mango.productservice.dto.request.ProductRequest;
import com.mango.productservice.dto.response.ProductResponse;
import com.mango.productservice.entities.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductEntity mapToProductEntity(ProductRequest request) {
        return ProductEntity.builder()
                .productName(request.getProductName())
                .Description(request.getDescription())
                .price(request.getPrice())
                .discount(request.getDiscount())
                .build();
    }

    public ProductResponse mapToProductResponse(ProductEntity entity) {
        return ProductResponse.builder()
                .id(entity.getId())
                .productName(entity.getProductName())
                .Description(entity.getDescription())
                .price(entity.getPrice())
                .discount(entity.getDiscount())
                .build();
    }
}
