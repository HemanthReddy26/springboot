package com.hcl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hcl.beans.Restaurant;

public class RestaurantMapper implements RowMapper<Restaurant> {

	public Restaurant mapRow(ResultSet rs, int rowNum) throws SQLException {

		 Restaurant res=new Restaurant();
        res.setId(Integer.parseInt(rs.getString("id")));
        res.setName(rs.getString("name"));
        res.setLocation(rs.getString("location"));
        res.setRating(Double.parseDouble(rs.getString("Rating")));
		return res;
	}

}
