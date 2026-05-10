package com.mango.productservice.repositories;

import com.mango.productservice.entities.ProductEntity;
import com.mango.productservice.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ProductRepository {
    private final List<ProductEntity> products = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(3);

    public ProductRepository() {
        products.add(new ProductEntity(1, "Apple", "Apple is a fruit", 100.0, 10.0));
        products.add(new ProductEntity(2, "Mango", "Mango is a fruit", 150.0, 20.0));
    }

    public int getNextId() {
        return idCounter.getAndIncrement();
    }

    public List<ProductEntity> getAllProducts() {
        return products;
    }

    public ProductEntity getProductById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));
    }

    public void saveProduct(ProductEntity product) {
        products.add(product);
    }

    public void deleteProduct(int id) {
        boolean removed = products.removeIf(product -> product.getId() == id);
        if (!removed) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
    }

    public ProductEntity updateProduct(int id, ProductEntity product) {
        ProductEntity existing = getProductById(id);
        existing.setProductName(product.getProductName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setDiscount(product.getDiscount());
        return existing;
    }
}
