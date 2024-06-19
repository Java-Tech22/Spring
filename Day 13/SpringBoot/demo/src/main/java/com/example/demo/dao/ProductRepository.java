package com.example.demo.dao;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;

@Repository
public interface ProductRepository  extends CrudRepository<Product,Integer> {
	
	
	public Iterable<Product> findAll();
		
	public Optional<Product> findById(int id);
	
	public void deleteProductById (int id);
	
	public void deleteAll();
	
	public Product save(Product product);
	
	
}
