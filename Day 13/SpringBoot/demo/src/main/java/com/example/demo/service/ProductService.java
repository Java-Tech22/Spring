package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;

public interface ProductService {
	
	public List<Product> getProducts();
	
	public Product saveProduct(Product product) ;
	
	public String deleteProductById(int id) ;

	public Product findProductById(int id);

	public Product updateProduct(int id, Product product);


}
