package com.mango.productservice.services.impl;

import com.mango.productservice.dto.request.ProductRequest;
import com.mango.productservice.dto.request.ProductUpdate;
import com.mango.productservice.dto.response.ProductResponse;
import com.mango.productservice.entities.ProductEntity;
import com.mango.productservice.mappers.ProductMapper;
import com.mango.productservice.repositories.ProductRepository;
import com.mango.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductImplement implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductResponse> getAllProducts() {
        List<ProductResponse> list = new ArrayList<>();
        List<ProductEntity> productEntityList = productRepository.findAll();
        productEntityList.forEach((data)->{
            ProductResponse productResponse = productMapper.mapToProductResponse(data);
            list.add(productResponse);
        });
        return list;
    }

    @Override
    public ProductResponse getProductById(int id) {
        ProductEntity entity = productRepository.findById(id).orElse(null);
        if(entity == null){
            throw new RuntimeException("Product not found");
        }
        return productMapper.mapToProductResponse(entity);
    }

    @Override
    public ProductRequest saveProduct(ProductUpdate request) {
        ProductEntity entity = productMapper.mapToProductEntity(request);
        productRepository.save(entity);
        return productMapper.mapToProductRequest(entity);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductRequest updateProduct(int id, ProductRequest request) {
        ProductEntity entity = productMapper.mapToProductEntity(request);
        var product = productRepository.findById(id).orElse(null);
        if(product == null){
            throw new RuntimeException("Product not found");
        }
        entity.setId(product.getId());
        product.setProductName(entity.getProductName());
        product.setDescription(entity.getDescription());
        product.setPrice(entity.getPrice());
        product.setDiscount(entity.getDiscount());
        product.setDeleted(entity.isDeleted());
        ProductEntity updated = productRepository.save(entity);
        return productMapper.mapToProductRequest(updated);
    }
}
