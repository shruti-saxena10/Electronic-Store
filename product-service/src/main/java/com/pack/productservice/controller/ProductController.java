package com.pack.productservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pack.productservice.dto.ProductRequest;
import com.pack.productservice.dto.ProductResponse;
import com.pack.productservice.service.ProductService;

import lombok.RequiredArgsConstructor;

//api the create the Products

@RestController
@RequestMapping("/api/product") 
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody ProductRequest productRequest) {
		//inject the ProductService into the ProductController
		productService.createProduct(productRequest);
		
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

}
