package com.hcl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.beans.Customer;
import com.hcl.beans.Restaurant;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer> {

	//void saveAll(List<Restaurant> restaurant);


}
