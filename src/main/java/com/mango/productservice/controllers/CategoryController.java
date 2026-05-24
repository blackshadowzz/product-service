package com.mango.productservice.controllers;


import com.mango.productservice.dto.request.CategoryDtoCreate;
import com.mango.productservice.dto.request.CategoryDtoUpdate;
import com.mango.productservice.exceptions.ApiException;
import com.mango.productservice.exceptions.MessageResponse;
import com.mango.productservice.services.impl.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")

public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getAllCategories(@RequestParam(required = false)String filter) {
        return new ResponseEntity<>(categoryService.getAllCategories(filter), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@RequestParam int id) {
        return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> saveCategory(@RequestBody @Valid CategoryDtoCreate request) {
        try {
            return new ResponseEntity<>(
                    categoryService.saveCategory(request),
                    HttpStatus.CREATED);
        }catch (ApiException e){
            return new ResponseEntity<>(
                    new MessageResponse(null,e.getMessage(),false,e.getError()),
                    HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable int id, @RequestBody @Valid CategoryDtoUpdate request) {
        return new ResponseEntity<>(
                categoryService.updateCategory(request),
                HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
