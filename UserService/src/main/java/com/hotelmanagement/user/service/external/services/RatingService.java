package com.hotelmanagement.user.service.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hotelmanagement.user.service.entities.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
	
	@GetMapping("/ratings/users/{userId}")
	List<Rating> getUserRatings(@PathVariable String userId);

}
