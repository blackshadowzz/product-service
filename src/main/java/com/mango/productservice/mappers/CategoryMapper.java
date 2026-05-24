package com.mango.productservice.mappers;

import com.mango.productservice.dto.request.CategoryDtoCreate;
import com.mango.productservice.dto.request.CategoryDtoUpdate;
import com.mango.productservice.dto.response.CategoryResponse;
import com.mango.productservice.entities.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryEntity maptoCategoryEntity(CategoryDtoCreate categoryDtoCreate) {
       return CategoryEntity
               .builder()
               .categoryName(categoryDtoCreate.getCategoryName())
               .description(categoryDtoCreate.getDescription())
               .isActive(categoryDtoCreate.isActive())
               .build();

    }
    public CategoryEntity maptoCategoryEntity(CategoryDtoUpdate categoryDtoUpdate) {
        return CategoryEntity
                .builder()
                .id(categoryDtoUpdate.getId())
                .categoryName(categoryDtoUpdate.getCategoryName())
                .description(categoryDtoUpdate.getDescription())
                .isActive(categoryDtoUpdate.isActive())
                .build();

    }
    public CategoryResponse mapToCategoryResponse(CategoryEntity entity) {
        return CategoryResponse.builder()
                .id(entity.getId())
                .categoryName(entity.getCategoryName())
                .description(entity.getDescription())
                .isActive(entity.isActive())
                .build();
    }
    public CategoryResponse mapToCategoryResponse(CategoryDtoCreate entity) {
        return CategoryResponse.builder()
                .categoryName(entity.getCategoryName())
                .description(entity.getDescription())
                .isActive(entity.isActive())
                .build();
    }
    public CategoryResponse mapToCategoryResponse(CategoryDtoUpdate entity) {
        return CategoryResponse.builder()
                .id(entity.getId())
                .categoryName(entity.getCategoryName())
                .description(entity.getDescription())
                .isActive(entity.isActive())
                .build();
    }
}
