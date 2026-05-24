package com.mango.productservice.services;

import com.mango.productservice.dto.request.CategoryDtoCreate;
import com.mango.productservice.dto.request.CategoryDtoUpdate;
import com.mango.productservice.dto.response.CategoryResponse;
import jakarta.validation.constraints.Null;

import java.util.List;

public interface ICategoryService {
    CategoryResponse saveCategory(CategoryDtoCreate entity);
    CategoryResponse updateCategory(CategoryDtoUpdate entity);
    void deleteCategory(int id);
    List<CategoryResponse> getAllCategories(String filter);
    CategoryResponse getCategoryById(int id);

}
