package com.hm.rating.service.services;

import java.util.List;

import com.hm.rating.service.entities.Rating;

public interface RatingService {
	
	Rating createRating(Rating rating);
	
	List<Rating> getRatings();
	
	List<Rating> getRatingsByUserId(String userId);
	
	List<Rating> getRatingByHotelId(String HotelId);

}
