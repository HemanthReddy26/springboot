package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.beans.Customer;
import com.hcl.exception.RestaurantException;
import com.hcl.services.ICustomerServices;



@RestController
public class CustomerController {
	
	@Autowired(required=true)
	ICustomerServices ics;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer cus) throws RestaurantException {
		return new ResponseEntity<Customer>(ics.addCustomer(cus),HttpStatus.OK);
	}

}
