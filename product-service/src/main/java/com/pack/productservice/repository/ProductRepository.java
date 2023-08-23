package com.pack.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pack.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product,String>{

}
