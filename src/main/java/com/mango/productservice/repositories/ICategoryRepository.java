package com.mango.productservice.repositories;

import com.mango.productservice.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}
