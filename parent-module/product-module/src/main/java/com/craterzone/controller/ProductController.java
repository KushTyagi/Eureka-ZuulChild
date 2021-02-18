package com.craterzone.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.craterzone.model.Product;
import com.craterzone.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
      
	  @Autowired
	  ProductService productService;
	  
	  @PostMapping
	  public ResponseEntity<Product> ragisterProduct(@RequestBody Product product){
		  Optional<Product> obj = productService.createProduct(product);
			 if(!obj.isPresent()) {
		        	return new ResponseEntity<>(null, HttpStatus.CONFLICT);
		        }
			 Product userObj = obj.get();
		            return new ResponseEntity<>(userObj, HttpStatus.CREATED);  
	  }
	  
	  @GetMapping
	  public ResponseEntity<Object> getProductWithUsers(@RequestHeader("Authorization") String accessToken)throws Exception{
		  productService.getProductWithUsers(accessToken);
		  return null;
	  }
}
