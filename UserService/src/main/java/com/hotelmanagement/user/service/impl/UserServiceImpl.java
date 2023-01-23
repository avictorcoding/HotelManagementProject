package com.hotelmanagement.user.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hotelmanagement.user.service.Repositories.UserRepository;
import com.hotelmanagement.user.service.entities.Hotel;
import com.hotelmanagement.user.service.entities.Rating;
import com.hotelmanagement.user.service.entities.User;
import com.hotelmanagement.user.service.exceptions.ResourceNotFoundException;
import com.hotelmanagement.user.service.external.services.HotelService;
import com.hotelmanagement.user.service.external.services.RatingService;
import com.hotelmanagement.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RatingService ratingService;

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		user.setUserId(UUID.randomUUID().toString());
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("id not found"));

//		Rating[] ratingArray = restTemplate
//				.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), Rating[].class);
//		
//		List<Rating> ratingList = Arrays.asList(ratingArray);
		
		List<Rating> ratingList = ratingService.getUserRatings(user.getUserId());
		
		ratingList.stream().map(rating -> {
			//ResponseEntity<Hotel> forEntity =  restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
//			rating.setHotel(forEntity.getBody());
			rating.setHotel(hotelService.getHotel(rating.getHotelId()));
			return rating;
		}).collect(Collectors.toList());
		
		user.setRatings(ratingList);

		return user;
	}

}
