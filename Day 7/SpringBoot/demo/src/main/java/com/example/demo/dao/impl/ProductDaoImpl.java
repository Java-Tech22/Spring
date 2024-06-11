package com.example.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.dao.productDao;
import com.example.demo.model.Product;

@Repository
public class ProductDaoImpl implements productDao{

	@Override
	public List<Product> findAll() {
		
		Product product1=new Product(1, "TV", "Smart TV");
		Product product2=new Product(2, "Refrigerator", "Cool");
		Product product3=new Product(3, "Laptop", "DEll Laptop");
		
		List<Product> list= new ArrayList<>();
		list.add(product1);
		list.add(product2);
		list.add(product3);
		
		// TODO Auto-generated method stub
		return list;
	}

}
