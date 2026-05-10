package com.mango.productservice.services.impl;

import com.mango.productservice.dto.request.ProductRequest;
import com.mango.productservice.dto.response.ProductResponse;
import com.mango.productservice.entities.ProductEntity;
import com.mango.productservice.mappers.ProductMapper;
import com.mango.productservice.repositories.ProductRepository;
import com.mango.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductImplement implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.getAllProducts()
                .stream()
                .map(productMapper::mapToProductResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProductById(int id) {
        return productMapper.mapToProductResponse(productRepository.getProductById(id));
    }

    @Override
    public ProductRequest saveProduct(ProductRequest request) {
        ProductEntity entity = productMapper.mapToProductEntity(request);
        entity.setId(productRepository.getNextId());
        productRepository.saveProduct(entity);
        request.setId(entity.getId());
        return request;
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }

    @Override
    public ProductRequest updateProduct(int id, ProductRequest request) {
        ProductEntity entity = productMapper.mapToProductEntity(request);
        ProductEntity updated = productRepository.updateProduct(id, entity);
        request.setId(updated.getId());
        return request;
    }
}
