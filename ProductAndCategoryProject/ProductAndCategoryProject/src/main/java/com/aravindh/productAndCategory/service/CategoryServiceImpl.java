package com.aravindh.productAndCategory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aravindh.productAndCategory.entities.Category;
import com.aravindh.productAndCategory.repos.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepository repository;

	@Override
	public List<Category> getAllCategories(PageRequest pageRequest) {
		return repository.findAll(pageRequest).getContent();
	}

	@Override
	public Category createNewCategory(Category category) {
		return repository.save(category);
	}

	@Override
	public Category getCategoryById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public void updateCategoryById(int id, String name) {
		Category category = repository.findById(id).get();
		category.setName(name);
		repository.save(category);	
	}

	@Override
	public void deleteCategoryById(int id) {
		repository.deleteById(id);		
	}

	

}
