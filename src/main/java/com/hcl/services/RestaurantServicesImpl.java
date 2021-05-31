package com.hcl.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.beans.Customer;
import com.hcl.beans.Restaurant;
import com.hcl.dao.CustomerDAO;
import com.hcl.dao.RestaurantDAO;
import com.hcl.exception.RestaurantException;

@Service
public class RestaurantServicesImpl implements IRestaurantServices {

	@Autowired
	private RestaurantDAO resDAO;

	
	
	public Restaurant addRestaurant(Restaurant res) throws RestaurantException {
		if(!resDAO.findById(res.getId()).isPresent()) {
			//resDAO.saveAll(res.getOwner());
			return resDAO.saveAndFlush(res);}
		else
			throw new RestaurantException("Id already Exists");
	}


	public boolean deleteRestaurant(int id) throws RestaurantException {
		if(resDAO.findById(id).isPresent()) {
			resDAO.deleteById(id);
		    return true;}
		else
			throw new RestaurantException("Id already deleted");
		
	}

	public Restaurant searchRestaurant(int id)  throws RestaurantException {
		//return resDAO.searchRestaurant(id);
		if(resDAO.findById(id).isPresent()) 
			return resDAO.findById(id).get();
		else
			throw new RestaurantException("Id doesnt Exists");
	}

	public List<Restaurant> displayRestaurant() {
		//return resDAO.displayRestaurant();
		return resDAO.findAll();
		//return resDAO.findAll().stream().filter(r->r.getRating()>5).collect(Collectors.toList());
	}

	public Restaurant updateRestaurant(Restaurant res, int id) throws RestaurantException {
		if(resDAO.findById(id).isPresent())
			return resDAO.saveAndFlush(res);
		else
			throw new RestaurantException("Id doesnt Exists");
	}


	@Override
	public Restaurant searchRestaurantByName(String name) {		
			return resDAO.findByName(name);		
	}
	
	public List<Restaurant> searchRestaurantByRating(double rating) {		
		return resDAO.findByRating(rating);		
}
	

}
