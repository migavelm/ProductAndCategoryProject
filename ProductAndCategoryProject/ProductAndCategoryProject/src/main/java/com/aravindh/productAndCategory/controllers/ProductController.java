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

import com.aravindh.productAndCategory.entities.Product;
import com.aravindh.productAndCategory.service.ProductService;

@RestController
@RequestMapping("api/products")
public class ProductController {
	
	@Autowired
	ProductService service;
	
//	http://localhost:8080/api/products?page=2
//	GET all the products
	@GetMapping
	public List<Product> getAllProducts(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){
		return service.getAllProducts(PageRequest.of(page, size));
	}

//	http://localhost:8080/api/products
//	POST - create a new product
	@PostMapping
	public ResponseEntity<Product> createNewProduct(@RequestBody Product product){
		Product newProduct = service.createNewProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
	}

//	http://localhost:8080/api/products/{di}
//	GET product by Id
	
	@GetMapping("/{di}")
	public Product getProductById(@PathVariable("di") int id) {
		return service.getProductById(id);
	}

//	http://localhost:8080/api/products/{di}
//	PUT - update product by id
	@PutMapping("/{di}")
	public ResponseEntity<String> updateProductById(@PathVariable("di") int id, @RequestParam("name") String name, @RequestParam("categoryId") int categoryId){
		service.updateProductById(id, name, categoryId);
		return ResponseEntity.ok("Updated SUccessfully");
	}

//	http://localhost:8080/api/products/{di}
//	DELETE - Delete product by id
	@DeleteMapping("/{di}")
	public ResponseEntity<String> deleteProductById(@PathVariable("di") int id){
		service.deleteProductById(id);
		return ResponseEntity.ok("Deleted Successfully");
	}
	

	
}
