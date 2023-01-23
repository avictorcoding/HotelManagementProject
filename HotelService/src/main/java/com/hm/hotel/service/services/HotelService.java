package com.hm.hotel.service.services;

import java.util.List;

import com.hm.hotel.service.entities.Hotel;

public interface HotelService {
	
	
	Hotel create(Hotel hotel);
	
	List<Hotel> getAllHotels();
	
	Hotel getHotel(String hotelId);

}
