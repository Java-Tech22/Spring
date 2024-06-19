package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.ProductRepository;
import com.example.demo.exceptions.CustomerNotFoundException;
import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl  implements ProductService{
	
	@Autowired
	ProductRepository repository;
	
	@Autowired
	CustomerService customerService;
	//CustomerRepository customerRepository;

	@Override
	public List<Product> getProducts() {
		Iterable<Product> products =repository.findAll();
		List<Product> list = new ArrayList<>();
		products.forEach(list::add);
		if(list.isEmpty()) {
			throw new ProductNotFoundException("No Products Available!!");
		}
		return list;
	}

	@Override
	public Product findProductById(int id) {
		Optional<Product> product= repository.findById(id);
		if(product.isPresent()) {
			return product.get();
		}
		else
			throw new ProductNotFoundException("No Products Available!!");
	}

	@Override
	public Product saveProduct(Product product) {
		if (product.getCustomer().getId()<0) {
			throw new CustomerNotFoundException("Customer Id does not exit/Please provide valid input ");
		}
		int id=product.getCustomer().getId();
		Customer c= customerService.findCustomerById(id);
		if(c!=null) {
			product.setCustomer(c);
			return repository.save(product);
		}else
			throw new CustomerNotFoundException("Customer Id : " + c.getId() +  " does not exit ");
		
	}
	
	/*
	 * public void saveProductWithCustomer() { Customer customer = new Customer();
	 * customer.setFirstName("John"); customerRepository.save(customer);
	 * 
	 * Product product = new Product(); product.setProductName("Sample Product");
	 * product.setCustomer(customer);
	 * 
	 * repository.save(product); }
	 */

	@Override
	public String deleteProductById(int id) {
		Optional<Product> product= repository.findById(id);
		if(product.isPresent()) {
			repository.deleteById(id);
			return "Product Deleted Successfully";
		}
		else
			throw new ProductNotFoundException("No Products Available!!");		
	}

	@Override
	public Product updateProduct(int id, Product product) {
		Product prod= findProductById(id);
	       if(prod!=null) {
	         	if(product.getProductName() != null)
	         		prod.setProductName(product.getProductName());
	         	if(product.getProductDescription() != null)
	         		prod.setProductDescription(product.getProductDescription());
	           
	            if(product.getCustomer() != null)
	            	prod.setCustomer(product.getCustomer());

	            	repository.save(prod);
	            	return  prod;
	       }
	        else{
	            throw new ProductNotFoundException("Product with given id: " + id +  " is not available !!");
	        }
	}

}
