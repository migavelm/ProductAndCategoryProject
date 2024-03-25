package com.aravindh.productAndCategory.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.aravindh.productAndCategory.entities.Category;

public interface CategoryService {

	public List<Category> getAllCategories(PageRequest pageRequest);

	public Category createNewCategory(Category category);
	
	public Category getCategoryById(int id);
	
	public void updateCategoryById(int id, String name);

	public void deleteCategoryById(int id);
}
