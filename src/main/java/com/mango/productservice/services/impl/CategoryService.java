package com.mango.productservice.services.impl;

import com.mango.productservice.dto.request.CategoryDtoCreate;
import com.mango.productservice.dto.request.CategoryDtoUpdate;
import com.mango.productservice.dto.response.CategoryResponse;
import com.mango.productservice.exceptions.ApiException;
import com.mango.productservice.mappers.CategoryMapper;
import com.mango.productservice.repositories.ICategoryRepository;
import com.mango.productservice.services.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final ICategoryRepository categoryRepository;
    private  final CategoryMapper categoryMapper;
    private boolean existingCategory;

    @Override
    public CategoryResponse saveCategory(CategoryDtoCreate entity) {
        var category= categoryMapper.maptoCategoryEntity(entity);
        var existingCategory=categoryRepository.getReferenceById(category.getId());
        if(existingCategory.getCategoryName().equals(category.getCategoryName())){
            throw new ApiException("409", "Category name already exists");
        }
        var created= categoryRepository.save(category);
        return categoryMapper.mapToCategoryResponse(created);
    }

    @Override
    public CategoryResponse updateCategory(CategoryDtoUpdate entity) {
        var category= categoryMapper.maptoCategoryEntity(entity);
        var categoryEntity= categoryRepository.findById(entity.getId()).orElse(null);
        if(categoryEntity == null){
            throw new RuntimeException("Category not found");
        }
        var updated= categoryRepository.save(category);
        return categoryMapper.mapToCategoryResponse(updated);
    }

    @Override
    public void deleteCategory(int id) {
        var category= categoryRepository.findById(id).orElse(null);
        if(category == null){
            throw new RuntimeException("Category not found");
        }
        categoryRepository.delete(category);
    }

    @Override
    public List<CategoryResponse> getAllCategories(String filter) {
        List<CategoryResponse> list = new ArrayList<>(categoryRepository.findAll()
                .stream()
                .map(categoryMapper::mapToCategoryResponse).toList());
        if(filter != null && !filter.isEmpty()){
            list.removeIf(category -> !category.getCategoryName().toLowerCase().contains(filter.toLowerCase()));
            return list;
        }
        return list;
    }

    @Override
    public CategoryResponse getCategoryById(int id) {
        var category= categoryRepository.findById(id).orElse(null);
        if(category == null){
            throw new RuntimeException("Category not found");
        }
        return categoryMapper.mapToCategoryResponse(category);
    }
}
