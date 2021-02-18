package com.craterzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.craterzone.gateway.RetrofitClientGateway;

@SpringBootApplication
@EnableEurekaClient
public class Product {

	public static void main(String[] arr) {
		System.out.println("Hello product");
		SpringApplication.run(Product.class, arr);
	}
	
	@Bean
	public RetrofitClientGateway getRetrofitClientGateway() {
		return new RetrofitClientGateway();
	}
}
