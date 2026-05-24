package com.mango.productservice.mappers;

import com.mango.productservice.dto.request.ProductRequest;
import com.mango.productservice.dto.request.ProductUpdate;
import com.mango.productservice.dto.response.ProductResponse;
import com.mango.productservice.entities.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductEntity mapToProductEntity(ProductRequest request) {
        return ProductEntity.builder()
                .productName(request.getProductName())
                .description(request.getDescription())
                .price(request.getPrice())
                .discount(request.getDiscount())
                .deleted(request.isDeleted())
                .build();
    }
    public ProductEntity mapToProductEntity(ProductUpdate request) {
        return ProductEntity.builder()
                .productName(request.getProductName())
                .description(request.getDescription())
                .price(request.getPrice())
                .discount(request.getDiscount())
                .deleted(request.isDeleted())
                .build();
    }

    public ProductResponse mapToProductResponse(ProductEntity entity) {
        return ProductResponse.builder()
                .id(entity.getId())
                .productName(entity.getProductName())
                .Description(entity.getDescription())
                .price(entity.getPrice())
                .discount(entity.getDiscount())
                .deleted(entity.isDeleted())
                .category(entity.getCategory())
                .build();
    }
    public ProductRequest mapToProductRequest(ProductEntity entity) {
        return ProductRequest.builder()
                .id(entity.getId())
                .productName(entity.getProductName())
                .Description(entity.getDescription())
                .price(entity.getPrice())
                .discount(entity.getDiscount())
                .deleted(entity.isDeleted())
                .build();
    }

}
