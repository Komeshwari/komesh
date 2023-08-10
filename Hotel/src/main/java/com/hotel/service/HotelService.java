package com.hotel.service;

import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.hotel.entity.Hotel;
public interface HotelService {
	public Hotel register(String hotelName,String hotelDesc,String location,MultipartFile hotelImg );
	public  Optional<Hotel> retrieveData(Integer Id);
	public Hotel updateData(Integer Id,String hotelName,String hotelDesc,String location,MultipartFile hotelImg);
	public String deleteData(Integer Id);
}
