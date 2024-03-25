package com.aravindh.productAndCategory.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aravindh.productAndCategory.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
