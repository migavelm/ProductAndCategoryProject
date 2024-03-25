package com.aravindh.productAndCategory.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.aravindh.productAndCategory.entities.Product;

public interface ProductService {
	
	public List<Product> getAllProducts(PageRequest pageRequest);

	public Product createNewProduct(Product product);
	
	public Product getProductById(int id);
	
	public void updateProductById(int productId, String name, int categoryId);

	public void deleteProductById(int id);
	
}
