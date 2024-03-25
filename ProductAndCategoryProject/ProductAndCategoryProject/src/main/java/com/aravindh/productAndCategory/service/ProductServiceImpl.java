package com.aravindh.productAndCategory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aravindh.productAndCategory.entities.Category;
import com.aravindh.productAndCategory.entities.Product;
import com.aravindh.productAndCategory.repos.CategoryRepository;
import com.aravindh.productAndCategory.repos.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<Product> getAllProducts(PageRequest pageRequest) {
		return productRepository.findAll(pageRequest).getContent();
	}

	@Override
	public Product createNewProduct(Product product) {
		return productRepository.save(product);

	}

	@Override
	public Product getProductById(int id) {
		return productRepository.findById(id).get();
	}

	@Override
	public void updateProductById(int productId, String name, int categoryId) {
		Product product = productRepository.findById(productId).get();
		Category category = categoryRepository.findById(categoryId).get();
		product.setProductName(name);
		product.setCategory(category);
		productRepository.save(product);
	}

	@Override
	public void deleteProductById(int id) {
		productRepository.deleteById(id);

	}

}
