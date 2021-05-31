package com.hcl.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.beans.Customer;
import com.hcl.dao.CustomerDAO;
import com.hcl.dao.RestaurantDAO;
import com.hcl.exception.RestaurantException;

@Service
public class CustomerServicesImpl implements ICustomerServices {
	
	@Autowired
	private CustomerDAO CusDAO;
	
	@Autowired
	private RestaurantDAO resDAO;
	

	@Override
	public Customer addCustomer(Customer cus) throws RestaurantException {
		if(!CusDAO.findById(cus.getId()).isPresent()) {
			resDAO.saveAll(cus.getRestaurant());
			return CusDAO.saveAndFlush(cus);
			}
		else
			throw new RestaurantException("Id already Exists");
	}
	

}
