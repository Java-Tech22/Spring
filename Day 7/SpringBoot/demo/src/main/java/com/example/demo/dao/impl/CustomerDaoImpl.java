package com.example.demo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.dao.customerDao;
import com.example.demo.model.Customer;


@Repository
public class CustomerDaoImpl implements customerDao{

	@Override
	public List<Customer> findAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

}
