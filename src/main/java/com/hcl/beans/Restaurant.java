package com.hcl.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="restaurant")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="name",nullable=false)
	private String name;
	
	@Column(name="location")
	private String location;
	
	@Column(name="rating")
	private double rating;
	
	//@Column(name="address",nullable=false)
	//private String address;

	//@ManyToOne
	//private Owner owner;
	


}
