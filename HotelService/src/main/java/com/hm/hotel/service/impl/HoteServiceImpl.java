package com.hm.hotel.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.hotel.service.entities.Hotel;
import com.hm.hotel.service.exceptions.ResourceNotFoundException;
import com.hm.hotel.service.repositories.HotelRepository;
import com.hm.hotel.service.services.HotelService;

@Service
public class HoteServiceImpl implements HotelService{
	
	@Autowired
	HotelRepository hotelRepository;

	@Override
	public Hotel create(Hotel hotel) {
		hotel.setId(UUID.randomUUID().toString());
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotel(String hotelId) {
		return hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("id not found"));
	}

}
