package com.aravindh.productAndCategory;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aravindh.productAndCategory.entities.Category;
import com.aravindh.productAndCategory.entities.Product;
import com.aravindh.productAndCategory.repos.CategoryRepository;
import com.aravindh.productAndCategory.repos.ProductRepository;

@SpringBootTest
class ProductAndCategoryProjectApplicationTests {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testCreateCategory() {
		Category category = new Category();
		category.setName("Mobile Phones");
		
		categoryRepository.save(category);
	}
	
	@Test
	void testDeleteCategoryById() {
		categoryRepository.deleteById(3);
	}
	
	@Test
	void testUpdateCategory() {
		Optional<Category> optCategory = categoryRepository.findById(3);
		if(optCategory.isPresent()) {
			Category category = optCategory.get();
			category.setName("PHONESSS");
			categoryRepository.save(category);
		}
	}
	
	@Test
	void testReadCategory() {
		List<Category> categories = categoryRepository.findAll();
		System.out.println(categories);
	}
	
	@Test
	void testReadCategoryByID() {
		Optional<Category> category = categoryRepository.findById(1);
		System.out.println(category);
	}
	
	//PRODUCTS
	@Test
	void testCreateProduct() {
		Product p = new Product();
		p.setProductName("Samsung");
		Category category = categoryRepository.findById(3).get();
		p.setCategory(category);
		productRepository.save(p);
	}
	
	@Test
	void testDeleteProductById() {
		productRepository.deleteById(1);
	}
	
	@Test
	void testUpdateProduct() {
		Product product = productRepository.findById(1).get();
		product.setProductName("Lenovo");
		productRepository.save(product);
	}
	
	@Test
	void testReadProduct() {
		List<Product> products = productRepository.findAll();
		System.out.println(products);
	}
	
	@Test
	void testReadProductByID() {
		Product product = productRepository.findById(1).get();
		System.out.println(product);
	}
	
	
	

}
