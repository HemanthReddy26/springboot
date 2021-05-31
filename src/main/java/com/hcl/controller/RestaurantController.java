package com.hcl.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.beans.Restaurant;
import com.hcl.exception.RestaurantException;
import com.hcl.services.IRestaurantServices;

@RestController
public class RestaurantController {
	
   @Autowired
    IRestaurantServices irs;
	
	@GetMapping("/display")
	public ResponseEntity<List<Restaurant>> displayRestaurant(){
		return new ResponseEntity<List<Restaurant>>(irs.displayRestaurant(),HttpStatus.OK);
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant res) throws RestaurantException {
		return new ResponseEntity<Restaurant>(irs.addRestaurant(res),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteRestaurant(@PathVariable int id) throws RestaurantException {
		return new ResponseEntity<Boolean>(irs.deleteRestaurant(id),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
     public ResponseEntity<Restaurant> updateRestaurant(@PathVariable int id,@RequestBody Restaurant res) throws RestaurantException {
		res.setId(id);
		return new ResponseEntity<Restaurant>(irs.updateRestaurant(res,id),HttpStatus.OK);
	} 
	
	@GetMapping("/search/{id}")
	public ResponseEntity<Restaurant> searchRestaurant(@PathVariable int id) throws RestaurantException{
		return new ResponseEntity<Restaurant>(irs.searchRestaurant(id),HttpStatus.OK);
	}
	
	@GetMapping("/searchByName")
	public ResponseEntity<Restaurant> searchRestaurantByName(String name) throws RestaurantException{
		return new ResponseEntity<Restaurant>(irs.searchRestaurantByName(name),HttpStatus.OK);
	}
	
	@GetMapping("/searchByRating/{rating}")
	public ResponseEntity<List<Restaurant>> searchRestaurantByRating(@PathVariable double rating) throws RestaurantException{
		return new ResponseEntity<List<Restaurant>>(irs.searchRestaurantByRating(rating),HttpStatus.OK);
	}
	
}
