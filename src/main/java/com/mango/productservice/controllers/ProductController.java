package com.mango.productservice.controllers;

import com.mango.productservice.dto.request.ProductRequest;
import com.mango.productservice.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<?> getProductById(@PathVariable("product-id") int id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody @Valid ProductRequest request) {
        return new ResponseEntity<>(productService.saveProduct(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody @Valid ProductRequest request) {
        return new ResponseEntity<>(productService.updateProduct(id, request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
