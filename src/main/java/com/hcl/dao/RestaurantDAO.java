package com.hcl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.beans.Restaurant;


@Repository
public interface RestaurantDAO extends JpaRepository<Restaurant,Integer> {
	
	public Restaurant findByName(String name);
	public Restaurant findByLocation(String Location);
	
	@Query(value = "SELECT id,name,location,rating,owner_id FROM restaurant r WHERE r.rating>?;", nativeQuery = true)
	public List<Restaurant> findByRating(double rating);
	
	/*@Autowired
	JdbcTemplate template;

	public Restaurant addRestaurant(Restaurant res) throws RestaurantException {
		
		if(searchRestaurant(res.getId()).size()==0) {
		String insert="insert into restaurant values(?,?,?,?)";
		template.update(insert,res.getId(),res.getName(),res.getLocation(),res.getRating());
		return res;
	   }else
			throw new RestaurantException("Restaurant already exists");	
	}
	
	public boolean updateRestaurant(Restaurant res,int id) throws RestaurantException{
		boolean rowUpdated=false;
		if(searchRestaurant(id).size()!=0) {
		String update="update restaurant set name=?,location=?,rating=? where id=?";
		rowUpdated=template.update(update,res.getName(),res.getLocation(),res.getRating(),id)>0;
		return rowUpdated;
		  }else
				throw new RestaurantException("Restaurant doesnt exists");

		}

	public Boolean deleteRestaurant(int id) throws RestaurantException {
		boolean rowDeleted=false;
		if(searchRestaurant(id).size()!=0) {
		String delete="delete from restaurant where id=?";
		rowDeleted=template.update(delete,id)>0;	
		return rowDeleted;	
		 }else
				throw new RestaurantException("Restaurant already Deleted");
		
	}

	public List<Restaurant> searchRestaurant(int id) throws RestaurantException {
		
		String search="select id,name,location,rating from restaurant where id=?";
		return template.query(search,new RestaurantMapper(),id);
	}
		
	public List<Restaurant> displayRestaurant() {
	       String display="select id,name,location,rating from Restaurant";
			return template.query(display,new RestaurantMapper());
		}*/

}
