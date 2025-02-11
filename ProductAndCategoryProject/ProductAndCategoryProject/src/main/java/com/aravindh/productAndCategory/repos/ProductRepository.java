package com.aravindh.productAndCategory.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aravindh.productAndCategory.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
