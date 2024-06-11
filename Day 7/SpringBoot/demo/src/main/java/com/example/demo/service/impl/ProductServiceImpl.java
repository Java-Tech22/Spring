package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.impl.ProductDaoImpl;
import com.example.demo.model.Product;
import com.example.demo.service.productService;

@Service
public class ProductServiceImpl  implements productService{

	@Autowired
	ProductDaoImpl productDao;
	
	@Override
	public List<Product> getProducts() {
		return productDao.findAll();
	}

}
