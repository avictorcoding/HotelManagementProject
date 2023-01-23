package com.hm.rating.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.rating.service.entities.Rating;
import com.hm.rating.service.repositories.RatingRepository;
import com.hm.rating.service.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	RatingRepository ratingRepository;

	@Override
	public Rating createRating(Rating rating) {
		rating.setRatingId(UUID.randomUUID().toString());
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingsByUserId(String userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String HotelId) {
		return ratingRepository.findByHotelId(HotelId);
	}

}
