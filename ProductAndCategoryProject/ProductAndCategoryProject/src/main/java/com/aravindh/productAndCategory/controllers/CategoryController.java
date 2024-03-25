package com.aravindh.productAndCategory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aravindh.productAndCategory.entities.Category;
import com.aravindh.productAndCategory.service.CategoryService;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
	
	@Autowired
	CategoryService service;
	

//	http://localhost:8080/api/categories?page=3
//	GET all the categories	
	@GetMapping
	public List<Category> getAllCAtegories(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
		
		return service.getAllCategories(PageRequest.of(page, size));
	}


//	http://localhost:8080/api/categories
//	POST - create a new category
	@PostMapping
	public ResponseEntity<Category> createNewCategory(@RequestBody Category category){
		Category createdCategory = service.createNewCategory(category);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
	}
	
	
//	http://localhost:8080/api/categories/{di}
//	GET category by Id
	@GetMapping("/{di}")
	public Category getCategoryById(@PathVariable("di") int id) {
		return service.getCategoryById(id);
	}


//	http://localhost:8080/api/categories/{di}
//	PUT - update category by id
	@PutMapping("/{di}")
	public ResponseEntity<String> updateCategoryById(@PathVariable("di") int id ,@RequestParam("name") String name) {
		service.updateCategoryById(id, name);
		return ResponseEntity.ok("Updated Successfully");
	}


//	http://localhost:8080/api/categories/{di}
//	DELETE - Delete category by id
	
	@DeleteMapping("/{di}")
	public ResponseEntity<String> deleteCategoryById(@PathVariable("di") int id){
		service.deleteCategoryById(id);
		return ResponseEntity.ok("Deleted Successfully");
	}
	
}
