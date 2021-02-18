package com.craterzone.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.craterzone.model.Product;

public interface ProductService {

	public Optional<Product> createProduct(Product email);
	public Optional<Product> getProduct();
	public Optional<Product> Update(Product u, long id);
	public Object fetchById(Object id);
	public ResponseEntity<Object> getProductWithUsers(String accessToken)throws Exception;
}
