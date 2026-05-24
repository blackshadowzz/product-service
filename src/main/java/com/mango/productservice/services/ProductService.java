package com.mango.productservice.services;

import com.mango.productservice.dto.request.ProductRequest;
import com.mango.productservice.dto.request.ProductUpdate;
import com.mango.productservice.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(int id);
    ProductRequest saveProduct(ProductUpdate request);
    void deleteProduct(int id);
    ProductRequest updateProduct(int id,ProductRequest request);
}
