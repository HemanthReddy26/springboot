package com.hcl.services;

import java.util.List;

import com.hcl.beans.Restaurant;
import com.hcl
.exception.RestaurantException;


public interface IRestaurantServices {
	
	public Restaurant addRestaurant(Restaurant res) throws RestaurantException;
	
	public Restaurant updateRestaurant(Restaurant r,int id) throws RestaurantException;

	public boolean deleteRestaurant(int id) throws RestaurantException;

	public Restaurant searchRestaurant(int id) throws RestaurantException;
	
	public List<Restaurant> displayRestaurant();

	public Restaurant searchRestaurantByName(String name);

	public List<Restaurant> searchRestaurantByRating(double rating);


}
