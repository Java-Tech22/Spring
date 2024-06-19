package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String productName;
	private String productDescription;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
	//@JsonIgnore
	private Customer customer;
	
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Product(int id, String productName, String productDescription, Customer customer) {
		super();
		this.id = id;
		this.productName = productName;
		this.productDescription = productDescription;
		this.customer = customer;
	}


	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getId() {
		return id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
