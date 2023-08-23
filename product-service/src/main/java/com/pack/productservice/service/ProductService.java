package com.pack.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pack.productservice.dto.ProductRequest;
import com.pack.productservice.dto.ProductResponse;
import com.pack.productservice.model.Product;
import com.pack.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
	//declaration of productRepository
	private final ProductRepository productRepository;
	
	public void createProduct(ProductRequest productRequest) {
		//declaration of productRepository
	 
		Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
		//inject the productrepository into the service class
		//Usingconstructor injection for that we need to access ProductRepository
		productRepository.save(product);
		log.info("Product {} is saved", product.getId());
	}

	public List<ProductResponse> getAllProducts() {
		List<Product> products= productRepository.findAll();
		return products.stream().map(this::mapToProductResponse).toList();
	}
		private ProductResponse mapToProductResponse(Product product) {
	        return ProductResponse.builder()
	                .id(product.getId())
	                .name(product.getName())
	                .description(product.getDescription())
	                .price(product.getPrice())
	                .build();
    
	}

}
