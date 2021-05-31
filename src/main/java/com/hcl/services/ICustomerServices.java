package com.hcl.services;


import com.hcl.beans.Customer;
import com.hcl.exception.RestaurantException;

public interface ICustomerServices {
	
	public Customer addCustomer(Customer cus) throws RestaurantException;

}
